package com.apk.easyinstall;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import com.hiapk.installer.utils.Log;
import dalvik.annotation.Signature;
import java.util.ArrayList;
import java.util.Iterator;

public class SystemAppAct extends ListActivity
{
  private static final boolean DEBUG = true;
  private static final String DEFAULT_SCAN_PATH = "/system/app";
  public static final int MENU_REMOVE = 1;
  public static final int MENU_SELECT = 2;
  private static final String SP_SHOW_SYSTEM_WARNNING = "show_system_warnning";
  private static final String TAG = "SystemAppAct";
  private static final String TEMP_FILE = "/system/app/hiapk.temp";
  private int current_removed;
  private ApkItemArrayAdapter mAdapter;
  private EnumThread mEnum;

  @Signature({"Ljava/util/ArrayList", "<", "Ljava/lang/String;", ">;"})
  private ArrayList mErrorPnames;

  @Signature({"Ljava/util/ArrayList", "<", "Lcom/hiapk/installer/ApkItem;", ">;"})
  private ArrayList mItems;
  private ProgressDialog mRemoveDialog = null;
  private ScanProgressDialog mScanDialog = null;
  private SharedPreferences mSp;
  private Handler myHandler;
  private boolean selectAll;

  public SystemAppAct()
  {
    ArrayList localArrayList = new ArrayList();
    this.mItems = localArrayList;
    this.mEnum = null;
    this.selectAll = null;
    this.current_removed = null;
    this.mErrorPnames = null;
    SystemAppAct.1 local1 = new SystemAppAct.1(this);
    this.myHandler = local1;
  }

  private void popProgressdialog()
  {
    boolean bool = null;
    this.current_removed = bool;
    ProgressDialog localProgressDialog1 = new ProgressDialog(this);
    this.mRemoveDialog = localProgressDialog1;
    int i = this.mAdapter.getSelectedCount();
    if (i <= 0)
      return;
    ProgressDialog localProgressDialog2 = new ProgressDialog(this);
    this.mRemoveDialog = localProgressDialog2;
    this.mRemoveDialog.setIndeterminate(bool);
    this.mRemoveDialog.setProgressStyle(1);
    this.mRemoveDialog.setProgress(bool);
    ProgressDialog localProgressDialog3 = this.mRemoveDialog;
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = getResources().getString(2130968582);
    String str2 = bool + "0/" + i;
    localProgressDialog3.setMessage(str2);
    this.mRemoveDialog.show();
  }

  private void selectAll()
  {
    boolean bool1 = true;
    int i = 0;
    int j = this.mAdapter.getSelectedCount();
    String str = "mCount = " + j;
    Log.v("SystemAppAct", str);
    int k = this.mAdapter.getCount();
    Object localObject;
    if (k == j)
    {
      this.selectAll = i;
      localObject = this.mAdapter;
      ((ApkItemArrayAdapter)localObject).setSelectedCount(i);
    }
    while (true)
    {
      localObject = this.mItems;
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (true)
      {
        localObject = localIterator.hasNext();
        if (localObject == 0)
          break label157;
        ApkItem localApkItem = (ApkItem)localIterator.next();
        boolean bool2 = this.selectAll;
        localApkItem.check = bool2;
      }
      this.selectAll = bool1;
      ApkItemArrayAdapter localApkItemArrayAdapter = this.mAdapter;
      int l = this.mAdapter.getCount();
      localApkItemArrayAdapter.setSelectedCount(l);
    }
    label157: boolean bool3 = this.selectAll;
    if (!bool3);
    for (bool3 = bool1; ; bool3 = i)
    {
      this.selectAll = bool3;
      this.mAdapter.notifyDataSetChanged();
      return;
    }
  }

  private void showScanDialog()
  {
    ScanProgressDialog localScanProgressDialog1 = new ScanProgressDialog(this);
    this.mScanDialog = localScanProgressDialog1;
    ScanProgressDialog localScanProgressDialog2 = this.mScanDialog;
    SystemAppAct.2 local2 = new SystemAppAct.2(this);
    localScanProgressDialog2.setOnCancelListener(local2);
    this.mScanDialog.show();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showScanDialog();
    setContentView(2130903041);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    this.mSp = localSharedPreferences;
    ArrayList localArrayList = this.mItems;
    ApkItemArrayAdapter localApkItemArrayAdapter1 = new ApkItemArrayAdapter(this, localArrayList, null);
    this.mAdapter = localApkItemArrayAdapter1;
    ApkItemArrayAdapter localApkItemArrayAdapter2 = this.mAdapter;
    setListAdapter(localApkItemArrayAdapter2);
    this.myHandler.sendEmptyMessage(1);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    String str1 = getString(2130968608);
    paramMenu.add(0, 1, 0, str1).setIcon(17301560);
    String str2 = getString(2130968578);
    paramMenu.add(0, 2, 0, str2).setIcon(17301586);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      if (this.mSp.getBoolean("show_system_warnning", true))
      {
        CheckBox localCheckBox = new CheckBox(this);
        localCheckBox.setText(2130968604);
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this).setIcon(17301543).setTitle(2130968605).setMessage(2130968603).setView(localCheckBox);
        SystemAppAct.4 local4 = new SystemAppAct.4(this);
        AlertDialog.Builder localBuilder2 = localBuilder1.setNegativeButton(17039360, local4);
        SystemAppAct.3 local3 = new SystemAppAct.3(this, localCheckBox);
        localBuilder2.setPositiveButton(17039370, local3).create().show();
      }
      removeSystemApp();
      continue;
      selectAll();
    }
  }

  protected void removeSystemApp()
  {
    Log.v("SystemAppAct", "removeSystemApp");
    popProgressdialog();
    ArrayList localArrayList = new ArrayList();
    this.mErrorPnames = localArrayList;
    SystemAppAct.5 local5 = new SystemAppAct.5(this);
    new Thread(local5).start();
  }
}
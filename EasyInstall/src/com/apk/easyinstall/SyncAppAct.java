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
import com.hiapk.installer.utils.Log;
import dalvik.annotation.Signature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class SyncAppAct extends ListActivity
{
  private static final boolean DEBUG = true;
  private static final String DEFAULT_SCAN_PATH = "/data/app";
  public static final String DEFAULT_SYNC_PATH = "/sdcard/hiapkBackup";
  public static final int MENU_SELECT = 2;
  public static final int MENU_SYNC = 1;
  private static final String TAG = "SyncAppAct";
  private int current_sync;
  private ApkItemArrayAdapter mAdapter;
  private EnumThread mEnum;

  @Signature({"Ljava/util/ArrayList", "<", "Ljava/lang/String;", ">;"})
  private ArrayList mErrorPnames;

  @Signature({"Ljava/util/ArrayList", "<", "Lcom/hiapk/installer/ApkItem;", ">;"})
  private ArrayList mItems;
  private String mRemoteSyncPath;
  private ScanProgressDialog mScanDialog = null;
  private SharedPreferences mSp;
  private ProgressDialog mSyncDialog = null;
  private Handler myHandler;
  private boolean selectAll;

  public SyncAppAct()
  {
    ArrayList localArrayList = new ArrayList();
    this.mItems = localArrayList;
    this.mEnum = null;
    this.current_sync = null;
    this.mErrorPnames = null;
    this.selectAll = null;
    SyncAppAct.1 local1 = new SyncAppAct.1(this);
    this.myHandler = local1;
  }

  private void doSyncApp()
  {
    Log.v("SyncAppAct", "removeSystemApp");
    popProgressdialog();
    ArrayList localArrayList = new ArrayList();
    this.mErrorPnames = localArrayList;
    SyncAppAct.4 local4 = new SyncAppAct.4(this);
    new Thread(local4).start();
  }

  private void popProgressdialog()
  {
    boolean bool = null;
    this.current_sync = bool;
    ProgressDialog localProgressDialog1 = new ProgressDialog(this);
    this.mSyncDialog = localProgressDialog1;
    int i = this.mAdapter.getSelectedCount();
    if (i <= 0)
      return;
    ProgressDialog localProgressDialog2 = new ProgressDialog(this);
    this.mSyncDialog = localProgressDialog2;
    this.mSyncDialog.setIndeterminate(bool);
    this.mSyncDialog.setProgressStyle(1);
    this.mSyncDialog.setProgress(bool);
    ProgressDialog localProgressDialog3 = this.mSyncDialog;
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = getResources().getString(2130968582);
    String str2 = bool + "0/" + i;
    localProgressDialog3.setMessage(str2);
    this.mSyncDialog.show();
  }

  private void selectAll()
  {
    boolean bool1 = true;
    int i = 0;
    int j = this.mAdapter.getSelectedCount();
    String str = "mCount = " + j;
    Log.v("SyncAppAct", str);
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
    SyncAppAct.2 local2 = new SyncAppAct.2(this);
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
    String str1 = getString(2130968602);
    paramMenu.add(0, 1, 0, str1).setIcon(2130837506);
    String str2 = getString(2130968578);
    paramMenu.add(0, 2, 0, str2).setIcon(17301586);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    switch (i)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      boolean bool = super.onOptionsItemSelected(paramMenuItem);
      while (true)
        while (true)
        {
          return bool;
          Object localObject = this.mSp.getString("apk", "/sdcard/hiapkBackup");
          this.mRemoteSyncPath = ((String)localObject);
          localObject = this.mRemoteSyncPath;
          File localFile = new File((String)localObject);
          localObject = localFile.exists();
          if (localObject == 0);
          try
          {
            localFile.createNewFile();
            doSyncApp();
          }
          catch (IOException localIOException)
          {
            StringBuilder localStringBuilder = new StringBuilder().append("Create dir failed:");
            String str1 = localIOException.getLocalizedMessage();
            String str2 = str1;
            Log.e("SyncAppAct", str2);
            localObject = new AlertDialog.Builder(this).setTitle(2130968576).setIcon(17301543).setMessage(2130968613);
            SyncAppAct.3 local3 = new SyncAppAct.3(this);
            ((AlertDialog.Builder)localObject).setPositiveButton(17039370, local3).create().show();
            int j = 1;
          }
        }
      selectAll();
    }
  }
}
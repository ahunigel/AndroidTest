package com.hiapk.installer;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageDeleteObserver.Stub;
import android.content.pm.IPackageInstallObserver.Stub;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.hiapk.installer.utils.Utils;
import android.content.pm.Signature;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppInstaller extends ListActivity
{
  private static final boolean DEBUG = true;
  public static final int FAILED = 255;
  public static final int FILE_CLEAR = 8;
  public static final int FILE_FOUND_ONE = 7;
  public static final int FILE_LOAD = 1;
  public static final int FILE_LOAD_DONE = 0;
  public static final int FREE_SPACE = 2;
  public static final int INSTALL_ALL_DONE = 4;
  public static final int INSTALL_COMPLETE = 3;
  public static final int MENU_INSTALL = 1;
  public static final int MENU_PATH = 3;
  public static final int MENU_SELECT = 2;
  public static final int NO_PERMISSION = 9;
  public static final String SCAN_APP = "org.openintents.action.PICK_DIRECTORY";
  public static final String SCAN_PATH = "apk";
  public static final int SEARCH_DIR = 6;
  public static final int SUCCEEDED = 1;
  private static final String TAG = "AppInstaller";
  public static final int UNINSTALL_COMPLETE = 5;
  public static boolean loadDone;
  public static boolean reloadAll;
  AlertDialog a_dlg;
  private int current_installed;
  private int current_num;
  private boolean flag;
  ProgressDialog h_p_dlg;

  @Signature({"Ljava/util/ArrayList", "<", "Lcom/hiapk/installer/ApkItem;", ">;"})
  ArrayList items;
  private ApkItemArrayAdapter mAdapter;
  ClearCacheReceiver mClearCacheReceiver;
  private EnumThread mEnum;
  private BroadcastReceiver mScanListener;
  private int m_installableCount;
  PackageManager manager;
  private Handler myHandler;
  ScanProgressDialog p_dlg;

  @Signature({"Ljava/util/List", "<", "Landroid/content/pm/PackageInfo;", ">;"})
  List packageList;
  private int position;
  private boolean redoFlag;
  private String scan_path;
  private boolean selectAll;

  static
  {
    boolean bool1 = reloadAll;
    boolean bool2 = loadDone;
  }

  public AppInstaller()
  {
    String str = Environment.getExternalStorageDirectory().toString();
    this.scan_path = str;
    this.mAdapter = null;
    this.m_installableCount = null;
    this.mEnum = null;
    AppInstaller.1 local1 = new AppInstaller.1(this);
    this.myHandler = local1;
    AppInstaller.5 local5 = new AppInstaller.5(this);
    this.mScanListener = local5;
    ArrayList localArrayList = new ArrayList();
    this.items = localArrayList;
  }

  private void checkOutOfSpace(long paramLong)
  {
    int i = 0;
    String str = "com.android.packageinstaller.CLEAR_CACHE";
    if (this.mClearCacheReceiver == null)
    {
      ClearCacheReceiver localClearCacheReceiver1 = new ClearCacheReceiver();
      this.mClearCacheReceiver = localClearCacheReceiver1;
    }
    ClearCacheReceiver localClearCacheReceiver2 = this.mClearCacheReceiver;
    IntentFilter localIntentFilter = new IntentFilter(str);
    registerReceiver(localClearCacheReceiver2, localIntentFilter);
    Intent localIntent = new Intent(str);
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this, i, localIntent, i);
    PackageManager localPackageManager = this.manager;
    IntentSender localIntentSender = localPendingIntent.getIntentSender();
    localPackageManager.freeStorage(paramLong, localIntentSender);
    ClearCacheReceiver localClearCacheReceiver3 = this.mClearCacheReceiver;
    unregisterReceiver(localClearCacheReceiver3);
  }

  private File createTempPackageFile(String paramString)
  {
    int i = 0;
    String str1 = "Error opening file ";
    String str2 = "AppInstaller";
    int j = paramString.lastIndexOf("/");
    int k = -1;
    String str3;
    if (j != k)
    {
      k = j + 1;
      str3 = paramString.substring(k);
    }
    while (true)
    {
      int l = 1;
      Object localObject;
      try
      {
        openFileOutput(str3, l).close();
        File localFile = getFileStreamPath(str3);
        Utils.copyFile(new File(paramString), localFile);
        localObject = localFile;
        label82: return localObject;
        str3 = paramString;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localObject = str1 + str3;
        Log.e(str2, (String)localObject);
        localObject = i;
        break label82:
      }
      catch (IOException localIOException)
      {
        localObject = str1 + str3;
        Log.e(str2, (String)localObject);
        localObject = i;
        break label82:
      }
    }
  }

  private void initAppList()
  {
    int i = 1;
    String str1 = Environment.getExternalStorageState();
    if (!"mounted".equals(str1))
    {
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this).setIcon(17301543);
      String str2 = getResources().getString(2130968591);
      AlertDialog.Builder localBuilder2 = localBuilder1.setTitle(str2);
      String str3 = getResources().getString(2130968592);
      AlertDialog.Builder localBuilder3 = localBuilder2.setMessage(str3);
      String str4 = getResources().getString(17039370);
      localBuilder3.setPositiveButton(str4, null).show();
    }
    while (true)
    {
      return;
      ArrayList localArrayList = this.items;
      ApkItemArrayAdapter localApkItemArrayAdapter1 = new ApkItemArrayAdapter(this, localArrayList, i);
      this.mAdapter = localApkItemArrayAdapter1;
      ApkItemArrayAdapter localApkItemArrayAdapter2 = this.mAdapter;
      setListAdapter(localApkItemArrayAdapter2);
      ScanProgressDialog localScanProgressDialog1 = new ScanProgressDialog(this);
      this.p_dlg = localScanProgressDialog1;
      ScanProgressDialog localScanProgressDialog2 = this.p_dlg;
      AppInstaller.4 local4 = new AppInstaller.4(this);
      localScanProgressDialog2.setOnCancelListener(local4);
      this.p_dlg.show();
      this.myHandler.sendEmptyMessage(i);
      PackageManager localPackageManager = getPackageManager();
      this.manager = localPackageManager;
      this.redoFlag = null;
    }
  }

  private void manageApk()
  {
    int i = 1;
    boolean bool1 = null;
    ListView localListView = getListView();
    int j = this.items.size();
    ApkItem localApkItem;
    boolean bool2;
    int i2;
    do
    {
      if (this.current_num >= j)
        break label249;
      ArrayList localArrayList = this.items;
      int k = this.current_num;
      localApkItem = (ApkItem)localArrayList.get(k);
      ApkItemArrayAdapter localApkItemArrayAdapter = (ApkItemArrayAdapter)localListView.getAdapter();
      int l = this.current_num;
      bool2 = localApkItemArrayAdapter.isClicked(l);
      int i1 = this.current_num;
      ++i2;
      this.current_num = i1;
    }
    while (!bool2);
    int i3 = this.current_installed;
    ++i2;
    this.current_installed = i3;
    if (localApkItem.state == 0)
    {
      int i4 = 0;
      PackageInstallObserver localPackageInstallObserver = new PackageInstallObserver();
      String str1 = localApkItem.uri;
      File localFile = createTempPackageFile(str1);
      if (localFile == null)
      {
        installError(bool1);
        label156: return;
      }
      int i5 = i4 | 0x2;
      Uri localUri = Uri.fromFile(localFile);
      StringBuilder localStringBuilder = new StringBuilder().append("Install package:");
      String str2 = localFile.getPath();
      String str3 = str2;
      Log.v("AppInstaller", str3);
      PackageManager localPackageManager1 = this.manager;
      String str4 = getPackageName();
      localPackageManager1.installPackage(localUri, localPackageInstallObserver, i4, str4);
    }
    for (localApkItem.state = i; ; localApkItem.state = bool1)
    {
      do
      {
        localApkItem.check = bool1;
        label249: if (this.current_num == j);
        this.myHandler.sendEmptyMessage(4);
        break label156:
      }
      while (localApkItem.state != i);
      PackageDeleteObserver localPackageDeleteObserver = new PackageDeleteObserver();
      PackageManager localPackageManager2 = this.manager;
      String str5 = localApkItem.uri;
      PackageInfo localPackageInfo = localPackageManager2.getPackageArchiveInfo(str5, i);
      PackageManager localPackageManager3 = this.manager;
      String str6 = localPackageInfo.applicationInfo.packageName;
      localPackageManager3.deletePackage(str6, localPackageDeleteObserver, bool1);
    }
  }

  private void recheckState()
  {
    int i = 1;
    Object localObject = null;
    this.redoFlag = localObject;
    List localList = this.manager.getInstalledPackages(i);
    ArrayList localArrayList1 = this.items;
    int j = this.position;
    String str1 = ((ApkItem)localArrayList1.get(j)).packageName;
    Iterator localIterator = localList.iterator();
    String str2;
    do
    {
      if (!localIterator.hasNext())
        break label122;
      str2 = ((PackageInfo)localIterator.next()).packageName;
    }
    while (!str1.equals(str2));
    ArrayList localArrayList2 = this.items;
    int k = this.position;
    ((ApkItem)localArrayList2.get(k)).state = i;
    this.mAdapter.notifyDataSetChanged();
    while (true)
    {
      return;
      label122: if (!this.flag)
        continue;
      ArrayList localArrayList3 = this.items;
      int l = this.position;
      ((ApkItem)localArrayList3.get(l)).state = localObject;
      this.mAdapter.notifyDataSetChanged();
    }
  }

  private void selectAll()
  {
    boolean bool1 = true;
    int i = 0;
    Object localObject1 = new StringBuilder().append("m_installableCount = ");
    int k = this.m_installableCount;
    localObject1 = k;
    Log.v("AppInstaller", (String)localObject1);
    int l = this.mAdapter.getSelectedCount();
    localObject1 = "mCount = " + l;
    Log.v("AppInstaller", (String)localObject1);
    int j = this.m_installableCount;
    Object localObject2;
    if (j == l)
    {
      this.selectAll = i;
      localObject2 = this.mAdapter;
      ((ApkItemArrayAdapter)localObject2).setSelectedCount(i);
    }
    while (true)
    {
      localObject2 = this.items;
      Iterator localIterator = ((ArrayList)localObject2).iterator();
      while (true)
      {
        localObject2 = localIterator.hasNext();
        if (localObject2 == 0)
          break label179;
        ApkItem localApkItem = (ApkItem)localIterator.next();
        boolean bool2 = this.selectAll;
        localApkItem.check = bool2;
      }
      this.selectAll = bool1;
      ApkItemArrayAdapter localApkItemArrayAdapter = this.mAdapter;
      int i1 = this.m_installableCount;
      localApkItemArrayAdapter.setSelectedCount(i1);
    }
    label179: boolean bool3 = this.selectAll;
    if (!bool3);
    for (bool3 = bool1; ; bool3 = i)
    {
      this.selectAll = bool3;
      this.mAdapter.notifyDataSetChanged();
      return;
    }
  }

  private void setScanPath()
  {
    String str = this.scan_path;
    setScanPath(str);
  }

  private void setScanPath(String paramString)
  {
    int i = 0;
    int j = 5;
    int k = 1;
    label19: EditText localEditText;
    AlertDialog.Builder localBuilder1;
    try
    {
      getPackageManager().getPackageInfo("org.openintents.filemanager", 0);
      localEditText = new EditText(this);
      localBuilder1 = new AlertDialog.Builder(this);
      localBuilder1.setIcon(17301659).setTitle(2130968576);
      if (k == null)
        break label174;
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = getString(2130968594);
      String str2 = str1 + "\n" + paramString;
      AlertDialog.Builder localBuilder2 = localBuilder1.setMessage(str2);
      AppInstaller.2 local2 = new AppInstaller.2(this);
      localBuilder2.setNeutralButton(2130968597, local2);
      AppInstaller.3 local3 = new AppInstaller.3(this, localEditText);
      localBuilder1.setPositiveButton(17039370, local3);
      localBuilder1.setNegativeButton(17039360, null).show();
      label174: return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject = null;
      break label19:
      localEditText.setText(paramString);
      int l = j;
      int i1 = j;
      localBuilder1.setView(localEditText, j, i, l, i1);
    }
  }

  public void installError(boolean paramBoolean)
  {
    int i = 1;
    ArrayList localArrayList = this.items;
    int j = this.current_num - i;
    ApkItem localApkItem = (ApkItem)localArrayList.get(j);
    if (paramBoolean)
      if (localApkItem.state <= 0)
        break label147;
    for (localApkItem.state = null; ; localApkItem.state = i)
    {
      if (this.h_p_dlg != null)
        this.h_p_dlg.dismiss();
      AlertDialog localAlertDialog1 = new AlertDialog.Builder(this).create();
      this.a_dlg = localAlertDialog1;
      AlertDialog localAlertDialog2 = this.a_dlg;
      String str1 = getResources().getString(2130968593);
      localAlertDialog2.setMessage(str1);
      AlertDialog localAlertDialog3 = this.a_dlg;
      String str2 = getResources().getString(17039370);
      MyListener localMyListener = new MyListener();
      localAlertDialog3.setButton(str2, localMyListener);
      this.a_dlg.show();
      label147: return;
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default:
    case 3:
    }
    while (true)
    {
      return;
      String str1;
      if (paramIntent != null)
      {
        str1 = paramIntent.getData().getPath();
        if ((str1 != null) && (new File(str1).exists()))
        {
          if (!str1.startsWith("/system"))
            break label97;
          CharSequence localCharSequence = getText(2130968612);
          Toast.makeText(this, localCharSequence, 1);
        }
      }
      setScanPath();
      continue;
      label97: this.scan_path = str1;
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this).edit();
      String str2 = this.scan_path;
      localEditor.putString("apk", str2).commit();
      initAppList();
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    String str = PreferenceManager.getDefaultSharedPreferences(this).getString("apk", null);
    if (str == null)
      setScanPath();
    while (true)
    {
      return;
      this.scan_path = str;
      initAppList();
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    String str1 = getString(2130968577);
    paramMenu.add(0, 1, 0, str1).setIcon(17301555);
    String str2 = getString(2130968578);
    paramMenu.add(0, 2, 0, str2).setIcon(17301560);
    String str3 = getString(2130968596);
    paramMenu.add(0, 3, 0, str3).setIcon(17301570);
    return true;
  }

  public void onDestroy()
  {
    int i = 0;
    super.onDestroy();
    Log.v("AppInstaller", "onDestroy");
    if (this.p_dlg != null)
    {
      this.p_dlg.dismiss();
      this.p_dlg = i;
    }
    if (this.h_p_dlg != null)
    {
      this.h_p_dlg.dismiss();
      this.h_p_dlg = i;
    }
    if (this.a_dlg == null)
      return;
    this.a_dlg.dismiss();
    this.a_dlg = i;
  }

  protected void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    super.onListItemClick(paramListView, paramView, paramInt, paramLong);
    int j = ((ApkItem)this.items.get(paramInt)).state;
    this.redoFlag = i;
    if (j == i)
    {
      this.position = paramInt;
      this.flag = i;
      StringBuilder localStringBuilder = new StringBuilder().append("package:");
      String str1 = ((ApkItem)this.items.get(paramInt)).packageName;
      Uri localUri1 = Uri.parse(str1);
      Intent localIntent1 = new Intent("android.intent.action.DELETE", localUri1);
      startActivity(localIntent1);
    }
    while (true)
    {
      return;
      if (j == 0)
      {
        this.position = paramInt;
        this.flag = null;
      }
      String str2 = ((ApkItem)this.items.get(paramInt)).uri;
      Intent localIntent2 = new Intent("android.intent.action.VIEW");
      Uri localUri2 = Uri.parse("file://" + str2);
      localIntent2.setDataAndType(localUri2, "application/vnd.android.package-archive");
      startActivity(localIntent2);
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = 0;
    switch (paramMenuItem.getItemId())
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return i;
      this.current_num = i;
      this.current_installed = i;
      int j = this.mAdapter.getSelectedCount();
      if (j <= 0)
        continue;
      ProgressDialog localProgressDialog1 = new ProgressDialog(this);
      this.h_p_dlg = localProgressDialog1;
      this.h_p_dlg.setIndeterminate(i);
      this.h_p_dlg.setProgressStyle(1);
      this.h_p_dlg.setProgress(i);
      ProgressDialog localProgressDialog2 = this.h_p_dlg;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = getResources().getString(2130968582);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
      int k = this.current_installed;
      String str2 = k + "/" + j;
      localProgressDialog2.setMessage(str2);
      this.h_p_dlg.show();
      manageApk();
      continue;
      selectAll();
      continue;
      setScanPath();
    }
  }

  protected void onPause()
  {
    super.onPause();
    BroadcastReceiver localBroadcastReceiver = this.mScanListener;
    unregisterReceiver(localBroadcastReceiver);
  }

  public void onResume()
  {
    super.onResume();
    Log.v("AppInstaller", "onResume");
    reloadAll = "AppInstaller";
    if ("AppInstaller" != null)
    {
      boolean bool = reloadAll;
      initAppList();
    }
    while (true)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
      localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
      localIntentFilter.addDataScheme("file");
      BroadcastReceiver localBroadcastReceiver = this.mScanListener;
      registerReceiver(localBroadcastReceiver, localIntentFilter);
      return;
      if (!this.redoFlag)
        continue;
      recheckState();
    }
  }

  class PackageDeleteObserver extends IPackageDeleteObserver.Stub
  {
    PackageDeleteObserver()
    {
    }

    public void packageDeleted(boolean paramBoolean)
    {
      Handler localHandler = AppInstaller.this.myHandler;
      Message localMessage = localHandler.obtainMessage(5);
      if (paramBoolean);
      for (int i = 1; ; i = -1)
      {
        localMessage.arg1 = i;
        AppInstaller.this.myHandler.sendMessage(localMessage);
        return;
      }
    }
  }

  class PackageInstallObserver extends IPackageInstallObserver.Stub
  {
    PackageInstallObserver()
    {
    }

    public void packageInstalled(String paramString, int paramInt)
    {
      Message localMessage = AppInstaller.this.myHandler.obtainMessage(3);
      localMessage.arg1 = paramInt;
      localMessage.obj = paramString;
      AppInstaller.this.myHandler.sendMessage(localMessage);
    }
  }

  class ClearCacheReceiver extends BroadcastReceiver
  {
    public static final String INTENT_CLEAR_CACHE = "com.android.packageinstaller.CLEAR_CACHE";

    ClearCacheReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = 1;
      Message localMessage = AppInstaller.this.myHandler.obtainMessage(2);
      int j = getResultCode();
      if (j == i);
      int k;
      for (j = i; ; k = -1)
      {
        localMessage.arg1 = j;
        AppInstaller.this.myHandler.sendMessage(localMessage);
        return;
      }
    }
  }

  class MyListener
    implements DialogInterface.OnClickListener
  {
    MyListener()
    {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      if (AppInstaller.this.a_dlg != null)
      {
        AppInstaller.this.a_dlg.dismiss();
        AppInstaller.this.a_dlg = null;
      }
      AppInstaller.this.mAdapter.notifyDataSetChanged();
    }
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.AppInstaller
 * JD-Core Version:    0.5.4
 */
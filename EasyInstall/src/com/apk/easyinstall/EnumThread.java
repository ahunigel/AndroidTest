package com.apk.easyinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageParser.Package;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import com.hiapk.installer.utils.Log;
import com.hiapk.installer.utils.PackageUtil;
import com.hiapk.installer.utils.Utils;
import dalvik.annotation.Signature;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class EnumThread extends Thread
{
  private static final boolean DEBUG = true;
  public static int MOD_INSDCARD = 0;
  public static int MOD_INSYSTEM = 0;
  public static int MOD_SCAN = 0;
  public static int MOD_SYNC = 0;
  private static final String TAG = "EnumThread";

  @Signature({"Ljava/util/HashSet", "<", "Ljava/lang/String;", ">;"})
  private static final HashSet pNameFilter = new HashSet();

  @Signature({"Ljava/util/HashSet", "<", "Ljava/lang/String;", ">;"})
  public static HashSet scanPnames;
  private int level;
  private Context mContext;
  private int mCurMod = -1;

  @Signature({"Ljava/util/ArrayList", "<", "Lcom/hiapk/installer/ApkItem;", ">;"})
  private ArrayList mItems;
  private PackageManager mManager;
  private int m_installableCount;
  private Handler myHandler;
  private boolean onlyLauncher = null;

  @Signature({"Ljava/util/List", "<", "Landroid/content/pm/PackageInfo;", ">;"})
  private List packageList;
  private int sApk;
  private int sDir;
  private int sFile;
  private boolean scan = true;
  private String scan_path;
  private boolean skipState = null;
  private boolean updateScanPnames = null;

  static
  {
    pNameFilter.add("com.hiapk.dialer");
    pNameFilter.add("com.hiapk.installer");
    pNameFilter.add("com.hiapk.market");
    pNameFilter.add("com.hiapk.homekey");
    scanPnames = new HashSet();
    MOD_INSDCARD = 1;
    MOD_INSYSTEM = 2;
    MOD_SYNC = 4;
    MOD_SCAN = 8;
  }

  @Signature({"(", "Landroid/content/Context;", "Ljava/lang/String;", "Landroid/os/Handler;", "Ljava/util/ArrayList", "<", "Lcom/hiapk/installer/ApkItem;", ">;I)V"})
  public EnumThread(Context paramContext, String paramString, Handler paramHandler, ArrayList paramArrayList, int paramInt)
  {
    this.mContext = paramContext;
    this.myHandler = paramHandler;
    this.scan_path = paramString;
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.mManager = localPackageManager;
    List localList = this.mManager.getInstalledPackages(1);
    this.packageList = localList;
    this.mItems = paramArrayList;
    this.mCurMod = paramInt;
  }

  private void refreshFileList(String paramString)
  {
    label62: label63: Object localObject5;
    File[] arrayOfFile;
    try
    {
      int i = this.level;
      int i8 = ++i;
      this.level = i8;
      i = this.level;
      int i9 = 4;
      if (i <= i9)
      {
        String str1 = paramString;
        String str2 = ".";
        bool1 = str1.startsWith(str2);
        if (!bool1)
          break label63;
      }
      int i12 = this.level - 1;
      this.level = i12;
      return;
      setFileScanMsg();
      Object localObject4 = new StringBuilder();
      localObject5 = "Scanning ";
      StringBuilder localStringBuilder1 = ((StringBuilder)localObject4).append((String)localObject5);
      String str3 = paramString;
      localObject4 = str3;
      Log.v("EnumThread", (String)localObject4);
      File localFile1 = new java/io/File;
      File localFile2 = localFile1;
      String str4 = paramString;
      localFile2.<init>(str4);
      boolean bool1 = localFile1.canRead();
      if (!bool1)
      {
        Log.v("EnumThread", "Try to get read permission");
        Object localObject1 = new StringBuilder();
        localObject4 = "/system/xbin/busybox  chmod a+r ";
        StringBuilder localStringBuilder2 = ((StringBuilder)localObject1).append((String)localObject4);
        String str5 = paramString;
        localObject1 = str5;
        Utils.rootCMD((String)localObject1);
      }
      arrayOfFile = localFile1.listFiles();
      if (arrayOfFile != null)
        break label253;
      label265: label780: label678: label568: label1084: label462: label731: label253: Log.e("EnumThread", "files is null!");
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder3 = new StringBuilder().append("Error:");
      String str6 = localException.getLocalizedMessage();
      String str7 = str6;
      Log.e("EnumThread", str7);
      break label62:
      localObject5 = arrayOfFile;
      int i13 = localObject5.length;
      Object localObject6 = null;
      Object localObject7 = localObject6;
      int i14 = i13;
      File localFile3;
      String str8;
      int i15;
      String str14;
      Drawable localDrawable;
      int i16;
      PackageParser.Package localPackage;
      String str15;
      int i17;
      String str16;
      ApplicationInfo localApplicationInfo;
      Resources localResources2;
      int i2;
      if (localObject7 < i14)
      {
        localFile3 = localObject5[localObject6];
        boolean bool2 = this.scan;
        if (!bool2)
          join();
        str8 = localFile3.getPath();
        i15 = str8.lastIndexOf('.');
        int j = i15 + 1;
        String str9 = str8.substring(j);
        String str10 = "apk";
        String str11 = str9;
        boolean bool3 = str10.equals(str11);
        if (!bool3)
        {
          String str12 = "APK";
          String str13 = str9;
          bool3 = str12.equals(str13);
          if (!bool3)
            break label1084;
        }
        str14 = null;
        localDrawable = null;
        i16 = null;
        Uri localUri = Uri.fromFile(localFile3);
        localPackage = PackageUtil.getPackageInfo(localUri);
        str15 = str8;
        i17 = (int)(localFile3.length() / 1024L);
        if (localPackage != null)
        {
          int k = this.m_installableCount;
          int i18 = ++k;
          this.m_installableCount = i18;
          str16 = localPackage.packageName;
          k = this.mCurMod;
          int i10 = MOD_SCAN;
          if (k == i10)
          {
            HashSet localHashSet1 = scanPnames;
            localHashSet1.add(str16);
          }
          PackageManager localPackageManager1;
          do
          {
            do
            {
              boolean bool4;
              do
              {
                ++localObject6;
                break label265:
                int l = this.mCurMod;
                i10 = MOD_INSYSTEM;
                if (l != i10)
                  break;
                bool4 = pNameFilter.contains(str16);
              }
              while (bool4);
              int i1 = this.mCurMod;
              i10 = MOD_SYNC;
              if (i1 != i10)
                break;
              bool5 = scanPnames.contains(str16);
            }
            while (bool5);
            localApplicationInfo = localPackage.applicationInfo;
            boolean bool5 = this.onlyLauncher;
            if (!bool5)
              break;
            localPackageManager1 = this.mManager;
          }
          while (localPackageManager1.getLaunchIntentForPackage(str16) == null);
          boolean bool6 = this.skipState;
          if (bool6)
          {
            i16 = 1;
            Resources localResources1 = this.mContext.getResources();
            AssetManager localAssetManager1 = new AssetManager();
            AssetManager localAssetManager2 = localAssetManager1;
            String str17 = str8;
            localAssetManager2.addAssetPath(str17);
            localResources2 = new android/content/res/Resources;
            DisplayMetrics localDisplayMetrics1 = localResources1.getDisplayMetrics();
            Configuration localConfiguration1 = localResources1.getConfiguration();
            Resources localResources3 = localResources2;
            AssetManager localAssetManager3 = localAssetManager1;
            DisplayMetrics localDisplayMetrics2 = localDisplayMetrics1;
            Configuration localConfiguration2 = localConfiguration1;
            localResources3.<init>(localAssetManager3, localDisplayMetrics2, localConfiguration2);
            i2 = localApplicationInfo.icon;
            if (i2 == 0);
          }
        }
      }
      int i3;
      try
      {
        i2 = localApplicationInfo.icon;
        Resources localResources4 = localResources2;
        int i19 = i2;
        localDrawable = localResources4.getDrawable(i19);
        if (localDrawable == null)
        {
          PackageManager localPackageManager2 = this.mManager;
          localDrawable = localPackageManager2.getDefaultActivityIcon();
        }
        i3 = localApplicationInfo.labelRes;
        if (i3 == 0);
      }
      catch (Resources.NotFoundException localNotFoundException2)
      {
        try
        {
          i3 = localApplicationInfo.labelRes;
          Resources localResources5 = localResources2;
          int i20 = i3;
          CharSequence localCharSequence = localResources5.getText(i20);
          str14 = localCharSequence.toString();
          if (str14 == null)
          {
            i4 = i15 + 1;
            str14 = str8.substring(i4);
          }
          int i21 = localPackage.mVersionCode;
          String str18 = localPackage.mVersionName;
          int i4 = this.sApk;
          int i22 = ++i4;
          this.sApk = i22;
          ApkItem localApkItem = new ApkItem(str8, str14, str15, i17, str16, i21, str18, localDrawable, i16, null);
          this.mItems.add(localApkItem);
          Handler localHandler = this.myHandler;
          int i11 = 7;
          localHandler.sendEmptyMessage(i11);
          boolean bool7 = this.updateScanPnames;
          if (bool7)
          {
            HashSet localHashSet2 = scanPnames;
            localHashSet2.add(str16);
          }
          boolean bool8;
          while (true)
          {
            int i5 = this.sFile;
            int i23 = ++i5;
            this.sFile = i23;
            i5 = this.level;
            i11 = 1;
            i5 -= i11;
            int i24 = i5;
            this.level = i24;
            setFileScanMsg();
            break label462:
            Object localObject2 = this.packageList;
            Iterator localIterator = ((List)localObject2).iterator();
            Object localObject3;
            do
            {
              PackageInfo localPackageInfo;
              int i26;
              int i27;
              do
              {
                do
                {
                  localObject2 = localIterator.hasNext();
                  if (localObject2 != 0);
                  localPackageInfo = (PackageInfo)localIterator.next();
                  localObject2 = localPackageInfo.packageName;
                  localObject2 = str16.equals(localObject2);
                }
                while (localObject2 == 0);
                int i6 = localPackage.mVersionCode;
                int i25 = localPackageInfo.versionCode;
                i26 = i6;
                i27 = i25;
              }
              while (i26 != i27);
              localObject3 = localPackage.mVersionName;
              if (localObject3 == null)
                break;
              localObject3 = localPackage.mVersionName;
              String str19 = localPackageInfo.versionName;
              Object localObject8 = localObject3;
              String str20 = str19;
              localObject3 = localObject8.equals(str20);
            }
            while (localObject3 == 0);
            i16 = 1;
            break label568:
            int i7 = this.mCurMod;
            i11 = MOD_SCAN;
            if (i7 != i11);
            localDrawable = this.mManager.getDefaultActivityIcon();
            i7 = i15 + 1;
            str14 = str8.substring(i7);
            str16 = null;
            i21 = -1;
            str18 = null;
            i16 = -1;
            break label780:
            bool8 = localFile3.isDirectory();
            if (!bool8)
              continue;
            bool8 = localFile3.canRead();
            if (!bool8)
              continue;
            EnumThread localEnumThread = this;
            String str21 = str8;
            localEnumThread.refreshFileList(str21);
          }
          int i28 = this.sDir;
          ++bool8;
          int i29 = i28;
          this.sDir = i29;
        }
        catch (Resources.NotFoundException localNotFoundException2)
        {
          break label731:
          localNotFoundException2 = localNotFoundException2;
          break label678:
        }
      }
    }
  }

  private void setFileScanMsg()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = this.mContext.getString(2130968584);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    int i = this.sDir;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(i).append("\n");
    String str2 = this.mContext.getString(2130968585);
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str2);
    int j = this.sFile;
    StringBuilder localStringBuilder5 = localStringBuilder4.append(j).append("\n");
    String str3 = this.mContext.getString(2130968586);
    StringBuilder localStringBuilder6 = localStringBuilder5.append(str3);
    int k = this.sApk;
    String str4 = k;
    localMessage.obj = str4;
    this.myHandler.sendMessage(localMessage);
  }

  public int getInstallableCount()
  {
    return this.m_installableCount;
  }

  public void run()
  {
    int i = 0;
    this.level = i;
    int j = this.mCurMod;
    int k = this.mCurMod;
    int l = MOD_SYNC;
    if (k == l)
    {
      AppInstaller.loadDone = k;
      if (k == 0)
      {
        String str1 = PreferenceManager.getDefaultSharedPreferences(this.mContext).getString("apk", "/sdcard/hiapkBackup");
        int i1 = MOD_SCAN;
        this.mCurMod = i1;
        scanPnames.clear();
        refreshFileList(str1);
      }
    }
    while (true)
    {
      this.mCurMod = j;
      String str2 = this.scan_path;
      refreshFileList(str2);
      this.myHandler.sendEmptyMessage(i);
      return;
      if (!this.updateScanPnames)
        continue;
      scanPnames.clear();
    }
  }

  public void setOnlyLauncher(boolean paramBoolean)
  {
    this.onlyLauncher = paramBoolean;
  }

  public void setScanState(boolean paramBoolean)
  {
    this.scan = paramBoolean;
  }

  public void setSkipState(boolean paramBoolean)
  {
    this.skipState = paramBoolean;
  }

  public void setUpdateScanPnames(boolean paramBoolean)
  {
    this.updateScanPnames = paramBoolean;
  }
}
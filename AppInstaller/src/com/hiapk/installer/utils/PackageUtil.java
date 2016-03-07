package com.hiapk.installer.utils;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageParser;
import android.content.pm.PackageParser.Package;
import android.net.Uri;
import android.util.DisplayMetrics;
import java.io.File;
import java.util.List;

public class PackageUtil
{
  public static final String INTENT_ATTR_APPLICATION_INFO = "com.android.packageinstaller.applicationInfo";
  public static final String INTENT_ATTR_INSTALL_STATUS = "com.android.packageinstaller.installStatus";
  public static final String INTENT_ATTR_PACKAGE_NAME = "com.android.packageinstaller.PackageName";
  public static final String INTENT_ATTR_PERMISSIONS_LIST = "com.android.packageinstaller.PermissionsList";
  public static final String PREFIX = "com.android.packageinstaller.";

  public static ApplicationInfo getApplicationInfo(Uri paramUri)
  {
    String str = paramUri.getPath();
    PackageParser localPackageParser = new PackageParser(str);
    File localFile = new File(str);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setToDefaults();
    int i = 0;
    PackageParser.Package localPackage = localPackageParser.parsePackage(localFile, str, localDisplayMetrics, i);
    if (localPackage == null)
      i = 0;
    while (true)
    {
      return i;
      ApplicationInfo localApplicationInfo = localPackage.applicationInfo;
    }
  }

  public static PackageParser.Package getPackageInfo(Uri paramUri)
  {
    String str = paramUri.getPath();
    PackageParser localPackageParser = new PackageParser(str);
    File localFile = new File(str);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setToDefaults();
    return localPackageParser.parsePackage(localFile, str, localDisplayMetrics, 0);
  }

  public static boolean isPackageAlreadyInstalled(Activity paramActivity, String paramString)
  {
    Object localObject1 = paramActivity.getPackageManager();
    List localList = ((PackageManager)localObject1).getInstalledPackages(8192);
    int j = localList.size();
    int k = 0;
    label24: int i;
    if (k < j)
    {
      localObject1 = ((PackageInfo)localList.get(k)).packageName;
      localObject1 = paramString.equalsIgnoreCase((String)localObject1);
      if (localObject1 != 0)
        i = 1;
    }
    while (true)
    {
      return i;
      ++k;
      break label24:
      Object localObject2 = null;
    }
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.utils.PackageUtil
 * JD-Core Version:    0.5.4
 */
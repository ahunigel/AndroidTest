package com.hiapk.installer;

import android.os.Handler;
import com.hiapk.installer.utils.Log;
import com.hiapk.installer.utils.Utils;
import dalvik.annotation.EnclosingMethod;
import java.util.ArrayList;

@EnclosingMethod
class SystemAppAct$5
  implements Runnable
{
  public void run()
  {
    String str1 = " failed!";
    String str2 = "SystemAppAct";
    int i = 0;
    int j = SystemAppAct.access$200(this.this$0).size();
    int k = i;
    if (k < j)
    {
      label23: ApkItem localApkItem = (ApkItem)SystemAppAct.access$200(this.this$0).get(k);
      if (!localApkItem.check)
        break label388;
      if ((Utils.rootCMD("mount -o remount,rw `mount|/system/xbin/busybox  grep \"/system \"|/system/xbin/busybox  awk '{ print $1 }'` /system") != 0) || (Utils.rootCMD("echo ' ' > /system/app/hiapk.temp") != 0))
      {
        Log.e(str2, "no permission!");
        SystemAppAct.access$400(this.this$0).sendEmptyMessage(9);
        label90: return;
      }
      StringBuilder localStringBuilder1 = new StringBuilder().append("/system/xbin/busybox  rm -f ");
      String str3 = localApkItem.uri;
      if (Utils.rootCMD(str3) == 0)
      {
        StringBuilder localStringBuilder2 = new StringBuilder().append("rm ");
        String str4 = localApkItem.uri;
        if (Utils.rootCMD(str4) == 0)
          break label208;
      }
      StringBuilder localStringBuilder3 = new StringBuilder().append("remove system app");
      String str5 = localApkItem.uri;
      String str6 = str5 + str1;
      Log.e(str2, str6);
      label208: StringBuilder localStringBuilder4 = new StringBuilder().append("pm uninstall ");
      String str7 = localApkItem.packageName;
      if (Utils.rootCMD(str7) != 0)
      {
        StringBuilder localStringBuilder5 = new StringBuilder().append("uninstall system app");
        String str8 = localApkItem.packageName;
        String str9 = str8 + str1;
        Log.e(str2, str9);
        ArrayList localArrayList1 = SystemAppAct.access$700(this.this$0);
        String str10 = localApkItem.name;
        localArrayList1.add(str10);
      }
    }
    for (i = k; ; i = k)
    {
      while (true)
      {
        k = ++i;
        break label23:
        SystemAppAct.access$508(this.this$0);
        ArrayList localArrayList2 = SystemAppAct.access$200(this.this$0);
        i = k + -1;
        localArrayList2.remove(k);
        --j;
        SystemAppAct.access$400(this.this$0).sendEmptyMessage(5);
      }
      SystemAppAct.access$400(this.this$0).sendEmptyMessage(4);
      label388: break label90:
    }
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.SystemAppAct.5
 * JD-Core Version:    0.5.4
 */
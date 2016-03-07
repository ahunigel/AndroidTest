package com.hiapk.installer;

import android.os.Handler;
import com.hiapk.installer.utils.Log;
import com.hiapk.installer.utils.Utils;
import dalvik.annotation.EnclosingMethod;
import java.util.ArrayList;

@EnclosingMethod
class SyncAppAct$4
  implements Runnable
{
  public void run()
  {
    String str1 = "SyncAppAct";
    int i = 0;
    int j = SyncAppAct.access$200(this.this$0).size();
    int k = i;
    if (k < j)
    {
      label19: ApkItem localApkItem = (ApkItem)SyncAppAct.access$200(this.this$0).get(k);
      if (!localApkItem.check)
        break label372;
      String str2 = localApkItem.path;
      int l = localApkItem.path.lastIndexOf('/');
      int i1;
      ++i1;
      int i2 = localApkItem.path.length();
      String str3 = str2.substring(l, i2);
      String str4 = "lfile name:" + str3;
      Log.v(str1, str4);
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str5 = SyncAppAct.access$800(this.this$0);
      String str6 = str5 + "/" + str3;
      String str7 = "rfile name:" + str6;
      Log.v(str1, str7);
      StringBuilder localStringBuilder2 = new StringBuilder().append("cp -f ");
      String str8 = localApkItem.path;
      if (Utils.rootCMD(str8 + " " + str6) != 0)
      {
        String str9 = "copy file " + str6 + "error!";
        Log.e(str1, str9);
        ArrayList localArrayList1 = SyncAppAct.access$700(this.this$0);
        String str10 = localApkItem.name;
        localArrayList1.add(str10);
      }
    }
    for (i = k; ; i = k)
    {
      while (true)
      {
        k = ++i;
        break label19:
        SyncAppAct.access$508(this.this$0);
        ArrayList localArrayList2 = SyncAppAct.access$200(this.this$0);
        i = k + -1;
        localArrayList2.remove(k);
        --j;
        SyncAppAct.access$400(this.this$0).sendEmptyMessage(3);
        boolean bool = AppInstaller.reloadAll;
      }
      SyncAppAct.access$400(this.this$0).sendEmptyMessage(4);
      label372: return;
    }
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.SyncAppAct.4
 * JD-Core Version:    0.5.4
 */
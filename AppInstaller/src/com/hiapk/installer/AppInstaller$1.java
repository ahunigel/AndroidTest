package com.hiapk.installer;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

class AppInstaller$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    int i = 2130968582;
    int j = 1;
    String str1 = "/";
    switch (paramMessage.what)
    {
    case 2:
    default:
    case 7:
    case 0:
    case 1:
    case 8:
    case 6:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return;
      AppInstaller.access$000(this.this$0).notifyDataSetChanged();
      continue;
      if (this.this$0.p_dlg != null)
        this.this$0.p_dlg.dismiss();
      boolean bool1 = AppInstaller.loadDone;
      AppInstaller localAppInstaller1 = this.this$0;
      int k = AppInstaller.access$200(this.this$0).getInstallableCount();
      AppInstaller.access$102(localAppInstaller1, k);
      continue;
      this.this$0.items.clear();
      boolean bool2 = AppInstaller.loadDone;
      AppInstaller localAppInstaller2 = this.this$0;
      AppInstaller localAppInstaller3 = this.this$0;
      String str2 = AppInstaller.access$300(this.this$0);
      Handler localHandler = AppInstaller.access$400(this.this$0);
      ArrayList localArrayList = this.this$0.items;
      int l = EnumThread.MOD_INSDCARD;
      EnumThread localEnumThread = new EnumThread(localAppInstaller3, str2, localHandler, localArrayList, l);
      AppInstaller.access$202(localAppInstaller2, localEnumThread);
      AppInstaller.access$200(this.this$0).setScanState(j);
      AppInstaller.access$200(this.this$0).setUpdateScanPnames(j);
      AppInstaller.access$200(this.this$0).setPriority(j);
      AppInstaller.access$200(this.this$0).start();
      continue;
      this.this$0.items.clear();
      continue;
      if (this.this$0.p_dlg == null)
        continue;
      ScanProgressDialog localScanProgressDialog = this.this$0.p_dlg;
      String str3 = (String)paramMessage.obj;
      localScanProgressDialog.setMessage(this);
      continue;
      if (paramMessage.arg1 != j)
        this.this$0.installError(j);
      int i1 = AppInstaller.access$000(this.this$0).getSelectedCount();
      if ((this.this$0.h_p_dlg == null) || (i1 <= 0))
        continue;
      ProgressDialog localProgressDialog1 = this.this$0.h_p_dlg;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str4 = this.this$0.getResources().getString(i);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str4);
      int i2 = AppInstaller.access$500(this.this$0);
      String str5 = i2 + str1 + i1;
      localProgressDialog1.setMessage(str5);
      ProgressDialog localProgressDialog2 = this.this$0.h_p_dlg;
      int i3 = AppInstaller.access$500(this.this$0) * 100 / i1;
      localProgressDialog2.setProgress(i3);
      this.this$0.h_p_dlg.show();
      AppInstaller.access$600(this.this$0);
      continue;
      if (this.this$0.h_p_dlg != null)
        this.this$0.h_p_dlg.dismiss();
      ApkItemArrayAdapter localApkItemArrayAdapter = AppInstaller.access$000(this.this$0);
      int i4 = AppInstaller.access$000(this.this$0).getSelectedCount();
      int i5 = AppInstaller.access$500(this.this$0);
      int i6 = i4 - i5;
      localApkItemArrayAdapter.setSelectedCount(i6);
      AppInstaller.access$000(this.this$0).notifyDataSetChanged();
      continue;
      if (paramMessage.arg1 != j)
        this.this$0.installError(j);
      i1 = AppInstaller.access$000(this.this$0).getSelectedCount();
      if ((this.this$0.h_p_dlg != null) && (i1 > 0))
      {
        ProgressDialog localProgressDialog3 = this.this$0.h_p_dlg;
        StringBuilder localStringBuilder3 = new StringBuilder();
        String str6 = this.this$0.getResources().getString(i);
        StringBuilder localStringBuilder4 = localStringBuilder3.append(str6);
        int i7 = AppInstaller.access$500(this.this$0);
        String str7 = i7 + str1 + i1;
        localProgressDialog3.setMessage(str7);
        ProgressDialog localProgressDialog4 = this.this$0.h_p_dlg;
        int i8 = AppInstaller.access$500(this.this$0) * 100 / i1;
        localProgressDialog4.setProgress(i8);
      }
      AppInstaller.access$600(this.this$0);
    }
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.AppInstaller.1
 * JD-Core Version:    0.5.4
 */
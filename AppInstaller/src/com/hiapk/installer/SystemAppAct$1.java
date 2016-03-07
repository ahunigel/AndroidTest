package com.hiapk.installer;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;

class SystemAppAct$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    int i = 17039370;
    int j = 1;
    switch (paramMessage.what)
    {
    case 2:
    case 3:
    default:
    case 7:
    case 0:
    case 1:
    case 8:
    case 6:
    case 5:
    case 4:
    case 9:
    }
    while (true)
    {
      label64: return;
      SystemAppAct.access$000(this.this$0).notifyDataSetChanged();
      continue;
      if (SystemAppAct.access$100(this.this$0) == null)
        continue;
      SystemAppAct.access$100(this.this$0).dismiss();
      continue;
      SystemAppAct.access$200(this.this$0).clear();
      SystemAppAct localSystemAppAct1 = this.this$0;
      SystemAppAct localSystemAppAct2 = this.this$0;
      Handler localHandler = SystemAppAct.access$400(this.this$0);
      ArrayList localArrayList = SystemAppAct.access$200(this.this$0);
      int k = EnumThread.MOD_INSYSTEM;
      EnumThread localEnumThread = new EnumThread(localSystemAppAct2, "/system/app", localHandler, localArrayList, k);
      SystemAppAct.access$302(localSystemAppAct1, localEnumThread);
      SystemAppAct.access$300(this.this$0).setScanState(j);
      SystemAppAct.access$300(this.this$0).setOnlyLauncher(j);
      SystemAppAct.access$300(this.this$0).setSkipState(j);
      SystemAppAct.access$300(this.this$0).setPriority(j);
      SystemAppAct.access$300(this.this$0).start();
      continue;
      SystemAppAct.access$200(this.this$0).clear();
      continue;
      if (SystemAppAct.access$100(this.this$0) == null)
        continue;
      ScanProgressDialog localScanProgressDialog = SystemAppAct.access$100(this.this$0);
      String str1 = (String)paramMessage.obj;
      localScanProgressDialog.setMessage(this);
      continue;
      SystemAppAct.access$000(this.this$0).notifyDataSetChanged();
      int l = SystemAppAct.access$000(this.this$0).getSelectedCount();
      ProgressDialog localProgressDialog1 = SystemAppAct.access$600(this.this$0);
      int i1 = SystemAppAct.access$500(this.this$0) * 100 / l;
      localProgressDialog1.setProgress(i1);
      ProgressDialog localProgressDialog2 = SystemAppAct.access$600(this.this$0);
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str2 = this.this$0.getResources().getString(2130968582);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
      int i2 = SystemAppAct.access$500(this.this$0);
      String str3 = i2 + "/" + l;
      localProgressDialog2.setMessage(str3);
      continue;
      if (SystemAppAct.access$600(this.this$0) != null)
        SystemAppAct.access$600(this.this$0).dismiss();
      int i3 = SystemAppAct.access$000(this.this$0).getSelectedCount();
      if (SystemAppAct.access$500(this.this$0) < i3)
      {
        String str4 = "";
        if (SystemAppAct.access$700(this.this$0).size() > 0)
        {
          str4 = this.this$0.getString(2130968610);
          Iterator localIterator = SystemAppAct.access$700(this.this$0).iterator();
          while (true)
          {
            if (!localIterator.hasNext())
              break label562;
            String str5 = (String)localIterator.next();
            str4 = str4 + "\n\t" + str5;
          }
        }
        str4 = this.this$0.getString(2130968611);
        label562: SystemAppAct localSystemAppAct3 = this.this$0;
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localSystemAppAct3).setTitle(2130968576).setMessage(str4);
        SystemAppAct.1.1 local1 = new SystemAppAct.1.1(this);
        localBuilder1.setPositiveButton(i, local1).create().show();
      }
      while (true)
      {
        ApkItemArrayAdapter localApkItemArrayAdapter = SystemAppAct.access$000(this.this$0);
        int i4 = SystemAppAct.access$500(this.this$0);
        int i5 = i3 - i4;
        localApkItemArrayAdapter.setSelectedCount(i5);
        break label64:
        SystemAppAct localSystemAppAct4 = this.this$0;
        CharSequence localCharSequence = this.this$0.getText(2130968609);
        Toast.makeText(localSystemAppAct4, localCharSequence, j);
      }
      if (SystemAppAct.access$600(this.this$0) != null)
        SystemAppAct.access$600(this.this$0).dismiss();
      SystemAppAct localSystemAppAct5 = this.this$0;
      AlertDialog.Builder localBuilder2 = new AlertDialog.Builder(localSystemAppAct5).setIcon(17301543).setTitle(2130968606).setMessage(2130968607);
      SystemAppAct.1.2 local2 = new SystemAppAct.1.2(this);
      localBuilder2.setPositiveButton(i, local2).create().show();
    }
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.SystemAppAct.1
 * JD-Core Version:    0.5.4
 */
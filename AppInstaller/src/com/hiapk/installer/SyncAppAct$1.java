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

class SyncAppAct$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    case 2:
    case 5:
    default:
    case 7:
    case 0:
    case 1:
    case 8:
    case 6:
    case 3:
      while (true)
      {
        label56: return;
        SyncAppAct.access$000(this.this$0).notifyDataSetChanged();
        continue;
        if (SyncAppAct.access$100(this.this$0) == null)
          continue;
        SyncAppAct.access$100(this.this$0).dismiss();
        continue;
        SyncAppAct.access$200(this.this$0).clear();
        SyncAppAct localSyncAppAct1 = this.this$0;
        SyncAppAct localSyncAppAct2 = this.this$0;
        Handler localHandler = SyncAppAct.access$400(this.this$0);
        ArrayList localArrayList = SyncAppAct.access$200(this.this$0);
        int j = EnumThread.MOD_SYNC;
        EnumThread localEnumThread = new EnumThread(localSyncAppAct2, "/data/app", localHandler, localArrayList, j);
        SyncAppAct.access$302(localSyncAppAct1, localEnumThread);
        SyncAppAct.access$300(this.this$0).setScanState(i);
        SyncAppAct.access$300(this.this$0).setSkipState(i);
        SyncAppAct.access$300(this.this$0).setPriority(i);
        SyncAppAct.access$300(this.this$0).start();
        continue;
        SyncAppAct.access$200(this.this$0).clear();
        continue;
        if (SyncAppAct.access$100(this.this$0) == null)
          continue;
        ScanProgressDialog localScanProgressDialog = SyncAppAct.access$100(this.this$0);
        String str1 = (String)paramMessage.obj;
        localScanProgressDialog.setMessage(this);
        continue;
        SyncAppAct.access$000(this.this$0).notifyDataSetChanged();
        int k = SyncAppAct.access$000(this.this$0).getSelectedCount();
        ProgressDialog localProgressDialog1 = SyncAppAct.access$600(this.this$0);
        int l = SyncAppAct.access$500(this.this$0) * 100 / k;
        localProgressDialog1.setProgress(l);
        ProgressDialog localProgressDialog2 = SyncAppAct.access$600(this.this$0);
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str2 = this.this$0.getResources().getString(2130968582);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
        int i1 = SyncAppAct.access$500(this.this$0);
        String str3 = i1 + "/" + k;
        localProgressDialog2.setMessage(str3);
      }
    case 4:
    }
    if (SyncAppAct.access$600(this.this$0) != null)
      SyncAppAct.access$600(this.this$0).dismiss();
    int i2 = SyncAppAct.access$000(this.this$0).getSelectedCount();
    if (SyncAppAct.access$500(this.this$0) < i2)
    {
      String str4 = "";
      if (SyncAppAct.access$700(this.this$0).size() > 0)
      {
        str4 = this.this$0.getString(2130968615);
        Iterator localIterator = SyncAppAct.access$700(this.this$0).iterator();
        while (true)
        {
          if (!localIterator.hasNext())
            break label541;
          String str5 = (String)localIterator.next();
          str4 = str4 + "\n\t" + str5;
        }
      }
      str4 = this.this$0.getString(2130968616);
      label541: SyncAppAct localSyncAppAct3 = this.this$0;
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(localSyncAppAct3).setTitle(2130968576).setMessage(str4);
      SyncAppAct.1.1 local1 = new SyncAppAct.1.1(this);
      localBuilder.setPositiveButton(17039370, local1).create().show();
    }
    while (true)
    {
      ApkItemArrayAdapter localApkItemArrayAdapter = SyncAppAct.access$000(this.this$0);
      int i3 = SyncAppAct.access$500(this.this$0);
      int i4 = i2 - i3;
      localApkItemArrayAdapter.setSelectedCount(i4);
      break label56:
      SyncAppAct localSyncAppAct4 = this.this$0;
      CharSequence localCharSequence = this.this$0.getText(2130968614);
      Toast.makeText(localSyncAppAct4, localCharSequence, i);
    }
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.SyncAppAct.1
 * JD-Core Version:    0.5.4
 */
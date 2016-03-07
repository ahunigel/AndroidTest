package com.hiapk.installer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

class AppInstaller$5 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED"))
      AppInstaller.access$400(this.this$0).sendEmptyMessage(8);
    while (true)
    {
      return;
      if (!paramIntent.getAction().equals("android.intent.action.MEDIA_MOUNTED"))
        continue;
      AppInstaller.access$400(this.this$0).sendEmptyMessage(1);
    }
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.AppInstaller.5
 * JD-Core Version:    0.5.4
 */
package com.hiapk.installer;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import dalvik.annotation.EnclosingMethod;

@EnclosingMethod
class AppInstaller$4
  implements DialogInterface.OnCancelListener
{
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (AppInstaller.access$200(this.this$0) == null)
      return;
    AppInstaller.access$200(this.this$0).setScanState(null);
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.AppInstaller.4
 * JD-Core Version:    0.5.4
 */
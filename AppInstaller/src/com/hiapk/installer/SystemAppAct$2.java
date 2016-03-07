package com.hiapk.installer;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import dalvik.annotation.EnclosingMethod;

@EnclosingMethod
class SystemAppAct$2
  implements DialogInterface.OnCancelListener
{
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (SystemAppAct.access$300(this.this$0) == null)
      return;
    SystemAppAct.access$300(this.this$0).setScanState(null);
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.SystemAppAct.2
 * JD-Core Version:    0.5.4
 */
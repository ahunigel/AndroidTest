package com.hiapk.installer;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import dalvik.annotation.EnclosingMethod;

@EnclosingMethod
class SystemAppAct$3
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.val$cb.isChecked())
      SystemAppAct.access$800(this.this$0).edit().putBoolean("show_system_warnning", null).commit();
    this.this$0.removeSystemApp();
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.SystemAppAct.3
 * JD-Core Version:    0.5.4
 */
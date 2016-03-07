package com.hiapk.installer;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.Toast;
import dalvik.annotation.EnclosingMethod;
import java.io.File;

@EnclosingMethod
class AppInstaller$3
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str1 = this.val$edit.getText().toString();
    if (str1.length() > 0)
      AppInstaller.access$302(this.this$0, str1);
    String str2 = AppInstaller.access$300(this.this$0);
    if (new File(str2).exists())
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.this$0).edit();
      String str3 = AppInstaller.access$300(this.this$0);
      localEditor.putString("apk", str3).commit();
      AppInstaller.access$700(this.this$0);
    }
    while (true)
    {
      return;
      Toast.makeText(this.this$0, 2130968595, 0).show();
      AppInstaller.access$800(this.this$0);
    }
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.AppInstaller.3
 * JD-Core Version:    0.5.4
 */
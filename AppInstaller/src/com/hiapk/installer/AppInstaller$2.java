package com.hiapk.installer;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import dalvik.annotation.EnclosingMethod;
import java.io.File;

@EnclosingMethod
class AppInstaller$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppInstaller localAppInstaller = this.this$0;
    String str = AppInstaller.access$300(this.this$0);
    Uri localUri = Uri.fromFile(new File(str));
    Intent localIntent = new Intent("org.openintents.action.PICK_DIRECTORY", localUri);
    localAppInstaller.startActivityForResult(localIntent, 3);
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.AppInstaller.2
 * JD-Core Version:    0.5.4
 */
package com.hiapk.installer;

import android.graphics.drawable.Drawable;
import java.io.Serializable;

public class ApkItem
  implements Serializable
{
  boolean check;
  Drawable drawable;
  String name;
  String packageName;
  String path;
  int size;
  int state;
  String uri;
  int versionCode;
  String versionName;

  public ApkItem(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5, Drawable paramDrawable, int paramInt3, boolean paramBoolean)
  {
    this.uri = paramString1;
    this.name = paramString2;
    this.path = paramString3;
    this.size = paramInt1;
    this.packageName = paramString4;
    this.versionCode = paramInt2;
    this.versionName = paramString5;
    this.drawable = paramDrawable;
    this.state = paramInt3;
    this.check = paramBoolean;
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.ApkItem
 * JD-Core Version:    0.5.4
 */
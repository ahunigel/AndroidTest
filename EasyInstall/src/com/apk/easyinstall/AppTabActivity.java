package com.apk.easyinstall;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class AppTabActivity extends TabActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    Resources localResources = getResources();
    TabHost localTabHost = getTabHost();
    Intent localIntent1 = new Intent().setClass(this, AppInstaller.class);
    TabHost.TabSpec localTabSpec1 = localTabHost.newTabSpec("insdcard");
    String str1 = getString(2130968600);
    Drawable localDrawable1 = localResources.getDrawable(2130837505);
    TabHost.TabSpec localTabSpec2 = localTabSpec1.setIndicator(str1, localDrawable1).setContent(localIntent1);
    localTabHost.addTab(localTabSpec2);
    Intent localIntent2 = new Intent().setClass(this, SystemAppAct.class);
    TabHost.TabSpec localTabSpec3 = localTabHost.newTabSpec("system");
    String str2 = getString(2130968601);
    Drawable localDrawable2 = localResources.getDrawable(2130837507);
    TabHost.TabSpec localTabSpec4 = localTabSpec3.setIndicator(str2, localDrawable2).setContent(localIntent2);
    localTabHost.addTab(localTabSpec4);
    Intent localIntent3 = new Intent().setClass(this, SyncAppAct.class);
    TabHost.TabSpec localTabSpec5 = localTabHost.newTabSpec("sync");
    String str3 = getString(2130968602);
    Drawable localDrawable3 = localResources.getDrawable(2130837506);
    TabHost.TabSpec localTabSpec6 = localTabSpec5.setIndicator(str3, localDrawable3).setContent(localIntent3);
    localTabHost.addTab(localTabSpec6);
    localTabHost.setCurrentTab(0);
  }
}

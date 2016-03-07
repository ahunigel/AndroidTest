package utils;

import android.text.TextUtils;

public final class Log
{
  private static final String LOGTAG = "AppInstaller";

  public static void e(String paramString1, String paramString2)
  {
    String str1 = "AppInstaller";
    if (TextUtils.isEmpty(paramString1))
      android.util.Log.e(str1, paramString2);
    while (true)
    {
      return;
      String str2 = paramString1 + ":" + paramString2;
      android.util.Log.e(str1, str2);
    }
  }

  public static void v(String paramString1, String paramString2)
  {
    String str1 = "AppInstaller";
    if (TextUtils.isEmpty(paramString1))
      android.util.Log.v(str1, paramString2);
    while (true)
    {
      return;
      String str2 = paramString1 + ":" + paramString2;
      android.util.Log.v(str1, str2);
    }
  }
}
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils
{
  public static final String BB = "/system/xbin/busybox ";
  private static boolean DEBUG = false;
  private static final String LOGTAG = "Utils";

  static
  {
    boolean bool = DEBUG;
  }

  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    boolean bool = null;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile1);
      try
      {
        bool = copyToFile(localFileInputStream, paramFile2);
        return bool;
      }
      finally
      {
        localFileInputStream.close();
      }
    }
    catch (IOException localIOException)
    {
      Object localObject1 = null;
    }
  }

  // ERROR //
  public static boolean copyToFile(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 42	java/io/FileOutputStream
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 43	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   10: astore_3
    //   11: sipush 4096
    //   14: istore 4
    //   16: iload 4
    //   18: newarray byte
    //   20: astore 5
    //   22: aload_0
    //   23: aload 5
    //   25: invokevirtual 47	java/io/InputStream:read	([B)I
    //   28: astore 6
    //   30: iload 6
    //   32: iflt +36 -> 68
    //   35: aconst_null
    //   36: istore 4
    //   38: aload_3
    //   39: aload 5
    //   41: iload 4
    //   43: iload 6
    //   45: invokevirtual 53	java/io/OutputStream:write	([BII)V
    //   48: goto -26 -> 22
    //   51: astore 4
    //   53: aload_3
    //   54: invokevirtual 54	java/io/OutputStream:close	()V
    //   57: aload 4
    //   59: athrow
    //   60: astore 7
    //   62: aload_2
    //   63: astore 4
    //   65: aload 4
    //   67: ireturn
    //   68: aload_3
    //   69: invokevirtual 54	java/io/OutputStream:close	()V
    //   72: iconst_1
    //   73: istore 4
    //   75: goto -10 -> 65
    //
    // Exception table:
    //   from	to	target	type
    //   16	48	51	finally
    //   2	11	60	java/io/IOException
    //   53	72	60	java/io/IOException
  }

  /** @deprecated */
  // ERROR //
  public static int rootCMD(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: astore_1
    //   3: aload_1
    //   4: monitorenter
    //   5: bipush 255
    //   7: istore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: invokestatic 64	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: ldc 66
    //   15: invokevirtual 70	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   18: astore 4
    //   20: aload 4
    //   22: invokevirtual 76	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   25: astore 5
    //   27: new 78	java/io/InputStreamReader
    //   30: dup
    //   31: aload 5
    //   33: invokespecial 81	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   36: astore 6
    //   38: new 83	java/io/BufferedReader
    //   41: dup
    //   42: aload 6
    //   44: sipush 8192
    //   47: invokespecial 86	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   50: astore 7
    //   52: aload 4
    //   54: invokevirtual 89	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   57: astore 8
    //   59: aload 4
    //   61: invokevirtual 93	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   64: astore 6
    //   66: new 95	java/io/DataOutputStream
    //   69: dup
    //   70: aload 6
    //   72: invokespecial 98	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   75: astore 9
    //   77: new 100	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   84: aload_0
    //   85: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 107
    //   90: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore 6
    //   98: aload 9
    //   100: aload 6
    //   102: invokevirtual 115	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   105: aload 9
    //   107: invokevirtual 118	java/io/DataOutputStream:flush	()V
    //   110: ldc 120
    //   112: astore 6
    //   114: aload 9
    //   116: aload 6
    //   118: invokevirtual 115	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   121: aload 9
    //   123: invokevirtual 118	java/io/DataOutputStream:flush	()V
    //   126: aload 7
    //   128: invokevirtual 123	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   131: astore 10
    //   133: aload 10
    //   135: ifnull +66 -> 201
    //   138: aload 6
    //   140: putstatic 19	com/hiapk/installer/utils/Utils:DEBUG	Z
    //   143: aload 6
    //   145: ifnull -19 -> 126
    //   148: ldc 15
    //   150: astore 6
    //   152: aload 6
    //   154: aload 10
    //   156: invokestatic 129	com/hiapk/installer/utils/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: goto -33 -> 126
    //   162: astore 6
    //   164: aload 6
    //   166: astore 11
    //   168: aload 9
    //   170: astore_3
    //   171: ldc 15
    //   173: astore 6
    //   175: aload 11
    //   177: invokevirtual 132	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   180: astore 12
    //   182: aload 6
    //   184: aload 12
    //   186: invokestatic 135	com/hiapk/installer/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_3
    //   190: ifnull +7 -> 197
    //   193: aload_3
    //   194: invokevirtual 136	java/io/DataOutputStream:close	()V
    //   197: aload_1
    //   198: monitorexit
    //   199: iload_2
    //   200: ireturn
    //   201: aload 4
    //   203: invokevirtual 140	java/lang/Process:waitFor	()I
    //   206: astore_2
    //   207: iload_2
    //   208: ifne +45 -> 253
    //   211: aload 6
    //   213: putstatic 19	com/hiapk/installer/utils/Utils:DEBUG	Z
    //   216: aload 6
    //   218: ifnull +62 -> 280
    //   221: ldc 15
    //   223: astore 6
    //   225: new 100	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   232: aload_0
    //   233: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc 142
    //   238: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: astore 13
    //   246: aload 6
    //   248: aload 13
    //   250: invokestatic 129	com/hiapk/installer/utils/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload 9
    //   255: invokevirtual 136	java/io/DataOutputStream:close	()V
    //   258: aload 4
    //   260: invokevirtual 145	java/lang/Process:destroy	()V
    //   263: aload 9
    //   265: ifnull +8 -> 273
    //   268: aload 9
    //   270: invokevirtual 136	java/io/DataOutputStream:close	()V
    //   273: aload 9
    //   275: astore 14
    //   277: goto -80 -> 197
    //   280: aload 6
    //   282: putstatic 19	com/hiapk/installer/utils/Utils:DEBUG	Z
    //   285: aload 6
    //   287: ifnull -34 -> 253
    //   290: ldc 15
    //   292: astore 6
    //   294: new 100	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   301: aload_0
    //   302: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 147
    //   307: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iload_2
    //   311: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: astore 15
    //   319: aload 6
    //   321: aload 15
    //   323: invokestatic 129	com/hiapk/installer/utils/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: goto -73 -> 253
    //   329: astore 6
    //   331: aload 6
    //   333: astore 11
    //   335: aload 9
    //   337: astore_3
    //   338: ldc 15
    //   340: astore 6
    //   342: aload 11
    //   344: invokevirtual 151	java/lang/InterruptedException:getLocalizedMessage	()Ljava/lang/String;
    //   347: astore 16
    //   349: aload 6
    //   351: aload 16
    //   353: invokestatic 135	com/hiapk/installer/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload_3
    //   357: ifnull -160 -> 197
    //   360: aload_3
    //   361: invokevirtual 136	java/io/DataOutputStream:close	()V
    //   364: goto -167 -> 197
    //   367: astore 17
    //   369: goto -172 -> 197
    //   372: astore 18
    //   374: aload 9
    //   376: astore 19
    //   378: goto -181 -> 197
    //   381: astore 6
    //   383: aload_3
    //   384: ifnull +7 -> 391
    //   387: aload_3
    //   388: invokevirtual 136	java/io/DataOutputStream:close	()V
    //   391: aload 6
    //   393: athrow
    //   394: astore 6
    //   396: aload_1
    //   397: monitorexit
    //   398: aload 6
    //   400: athrow
    //   401: astore 20
    //   403: goto -206 -> 197
    //   406: astore 21
    //   408: goto -17 -> 391
    //   411: astore 6
    //   413: aload 9
    //   415: astore_3
    //   416: goto -33 -> 383
    //   419: astore 6
    //   421: aload 6
    //   423: astore 11
    //   425: goto -87 -> 338
    //   428: astore 6
    //   430: aload 6
    //   432: astore 11
    //   434: goto -263 -> 171
    //   437: astore 6
    //   439: aload 9
    //   441: astore 22
    //   443: goto -47 -> 396
    //
    // Exception table:
    //   from	to	target	type
    //   77	159	162	java/io/IOException
    //   201	263	162	java/io/IOException
    //   280	326	162	java/io/IOException
    //   77	159	329	java/lang/InterruptedException
    //   201	263	329	java/lang/InterruptedException
    //   280	326	329	java/lang/InterruptedException
    //   360	364	367	java/io/IOException
    //   268	273	372	java/io/IOException
    //   10	77	381	finally
    //   171	189	381	finally
    //   338	356	381	finally
    //   193	197	394	finally
    //   360	364	394	finally
    //   387	391	394	finally
    //   391	394	394	finally
    //   193	197	401	java/io/IOException
    //   387	391	406	java/io/IOException
    //   77	159	411	finally
    //   201	263	411	finally
    //   280	326	411	finally
    //   10	77	419	java/lang/InterruptedException
    //   10	77	428	java/io/IOException
    //   268	273	437	finally
  }
}
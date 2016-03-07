package com.hello.today;

import java.util.Calendar;

import com.hello.day0604.R;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HelloTodayActivity extends Activity {
    /** Called when the activity is first created. */
	ImageView iv = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//		TextView tv = new TextView(this); 
//        setContentView(tv); 
        setContentView(R.layout.main);
        TextView tv = (TextView) findViewById(R.id.textView2); 
        tv.setText("Hello, Android, "+today()); 
        System.out.println(this.getPackageName());
        System.out.println(this.getPackageResourcePath());
		onAPKInfoDisplay(this.getPackageResourcePath());
    }

	private String today() {
		// TODO Auto-generated method stub
        // get the current date 
		int mYear;
	    int mMonth; 
	    int mDay;
		Calendar c = Calendar.getInstance(); 
        mYear = c.get(Calendar.YEAR); 
        mMonth = c.get(Calendar.MONTH); 
        mDay = c.get(Calendar.DAY_OF_MONTH); 

		return mYear+"-"+mMonth+"-"+mDay;
	}

    public void onAPKInfoDisplay(String strPath)

    {

	    String strInfo="";
	
	    PackageManager pm=this.getPackageManager();
	
	    PackageInfo pInfo=pm.getPackageArchiveInfo(strPath, PackageManager.GET_ACTIVITIES);
	
	    ApplicationInfo appInfo=pInfo.applicationInfo;
	
	    strInfo+="Lable："+pm.getApplicationLabel(appInfo).toString()+"\n";
	
	    strInfo+="Package："+appInfo.packageName+"\n";
	
	    strInfo+="Version："+pInfo.versionName+" "+pInfo.versionCode;
	
//	    Drawable icon = pm.getApplicationIcon(appInfo);//得到图标信息 

	    Drawable icon;
    	try {
			icon = pm.getApplicationIcon(appInfo.packageName);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			icon = pm.getApplicationIcon(appInfo);
			e.printStackTrace();
		}
	
	    TextView tv = (TextView) findViewById(R.id.textView1); //显示图标 

	    tv.setText(strInfo);
	    
	    iv = (ImageView) findViewById(R.id.imageView1);

		iv.setImageDrawable(icon);

	    System.out.println(strInfo);
	    Toast.makeText(this, strInfo, Toast.LENGTH_LONG).show();

    }
}
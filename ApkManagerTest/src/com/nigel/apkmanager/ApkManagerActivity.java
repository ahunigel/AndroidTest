package com.nigel.apkmanager;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ApkManagerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final String str = Environment.getExternalStorageDirectory().toString();
        final String str2 = Environment.getExternalStorageState();
        Button btnShow = (Button) findViewById(R.id.button1); 
        final TextView txtView = (TextView) findViewById(R.id.textView1);
        TextView txtV = (TextView) findViewById(R.id.textView2);
        txtV.setText(str);
        // add a click listener to the button 
        btnShow.setOnClickListener(new View.OnClickListener() { 
           public void onClick(View v) { 
               txtView.setText(str2); 
           } 
       }); 
		
    }
}
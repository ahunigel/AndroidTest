package com.test.progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.test.IsolatedContext;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarTestActivity extends Activity {
	private ProgressBar barH = null;
	private ProgressBar barCircle = null;
	private Button btnManual = null;
	private Button btnAuto = null;
	private int i = 0;
	private int j = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnManual = (Button) findViewById(R.id.manual);
        btnAuto = (Button) findViewById(R.id.auto);
        barH = (ProgressBar) findViewById(R.id.Bar1);
        barCircle = (ProgressBar) findViewById(R.id.Bar2);
        
        btnManual.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (i == 0) {
					//设置进度条为可见
					barH.setVisibility(View.VISIBLE);
					barCircle.setVisibility(View.VISIBLE);
				} else if (i < 100) {
					//设置进度条的当前值
					barH.setProgress(i);
					barH.setSecondaryProgress(i + 10);
					barCircle.setProgress(i);
				} else if (i < 200) {
					//设置进度条的当前值
					barH.setMax(150);
					barH.setProgress(i);
					barH.setSecondaryProgress(i + 10);
					barCircle.setProgress(i);
				} else {
					barH.setVisibility(View.GONE);
					barCircle.setVisibility(View.GONE);
					i = -10;
				}
				i = i+ 10;
				System.out.println("i = "+ i);
			}
		});
        
        btnAuto.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				do {
					j = j + 10;
					System.out.println("j = "+ j);
					barH.setVisibility(View.VISIBLE);
					barCircle.setVisibility(View.VISIBLE);
					barH.setProgress(j);
					barH.setSecondaryProgress(j + 10);
					barCircle.setProgress(j);
					
				} while (j<100);
			}
		});
    }
}
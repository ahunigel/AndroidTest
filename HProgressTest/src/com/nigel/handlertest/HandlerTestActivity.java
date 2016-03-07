package com.nigel.handlertest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HandlerTestActivity extends Activity {
	private Button btnStart = null;
	private Button btnEnd = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        findView();
        addListener();
    }
    
	private void findView(){
    	btnStart = (Button) findViewById(R.id.btnStart);
    	btnEnd = (Button) findViewById(R.id.btnEnd);
    }

    private void addListener() {
		// TODO Auto-generated method stub
		btnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//调用Handler的post方法，将要执行的线程对象加入到队列中
				handler.post(updateThread);
				
			}
		});
		
		btnEnd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				handler.removeCallbacks(updateThread);
				System.out.println("updateThread stoped!");
			}
		});
	}
    
    //创建一个Handler对象，用来实现异步线程处理，activity是一个线程，handler又是一个线程
    Handler handler = new Handler();
    //将要执行的操作写在线程对象的run方法中
    Runnable updateThread = new Runnable() {
    	int i = 0;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			i++;
			System.out.println("update thread "+i);
			Toast.makeText(getApplicationContext(), "updateThread "+i, Toast.LENGTH_SHORT).show();
			//在run方法内部，执行postDelay或者post方法
			handler.postDelayed(updateThread, 3000);
			
		}
	};

}
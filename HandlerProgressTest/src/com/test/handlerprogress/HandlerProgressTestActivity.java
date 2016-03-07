package com.test.handlerprogress;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class HandlerProgressTestActivity extends Activity {
	private ProgressBar bar = null;
	private Button btnGo = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bar = (ProgressBar) findViewById(R.id.progressBar1);
        btnGo = (Button) findViewById(R.id.btnGo);
        
        btnGo.setOnClickListener(new BtnGoListener());
    }
    //当点击btnGo按钮时，就会执行BtnGoListener的onClick方法
    class BtnGoListener implements OnClickListener{
    	
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		bar.setVisibility(View.VISIBLE);
    		updateBarHandler.post(updateThread);
    		
    	}
    }
    //使用匿名内部类来复写handler的handleMessage方法
    Handler updateBarHandler = new Handler(){
    	@Override
    	public void handleMessage(Message msg) {
    		// TODO Auto-generated method stub
//    		super.handleMessage(msg);
    		bar.setProgress(msg.arg1);
    		updateBarHandler.post(updateThread);
    	}
    };
    
    
    //线程类，使用匿名内部类的方法进行声明
    Runnable updateThread = new Runnable() {
    	int i = 0;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Begin thread");
			i++;
			i++;
			i++;
			i++;
			//得到一个消息对象，message对象由android系统提供
			Message msg = updateBarHandler.obtainMessage();
			//将msg对象的arg1参数的值设置为i，用arg1和arg2这两个成员变量传递消息，
			//优点是系统性能消耗较少
			msg.arg1 = i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//将msg加入到消息队列当中
			updateBarHandler.sendMessage(msg);
			if (i == 100) {
				updateBarHandler.removeCallbacks(updateThread);
			}
		}
	};
    
    
}
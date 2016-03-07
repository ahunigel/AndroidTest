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
				//����Handler��post��������Ҫִ�е��̶߳�����뵽������
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
    
    //����һ��Handler��������ʵ���첽�̴߳���activity��һ���̣߳�handler����һ���߳�
    Handler handler = new Handler();
    //��Ҫִ�еĲ���д���̶߳����run������
    Runnable updateThread = new Runnable() {
    	int i = 0;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			i++;
			System.out.println("update thread "+i);
			Toast.makeText(getApplicationContext(), "updateThread "+i, Toast.LENGTH_SHORT).show();
			//��run�����ڲ���ִ��postDelay����post����
			handler.postDelayed(updateThread, 3000);
			
		}
	};

}
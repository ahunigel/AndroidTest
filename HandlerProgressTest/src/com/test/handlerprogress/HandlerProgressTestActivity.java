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
    //�����btnGo��ťʱ���ͻ�ִ��BtnGoListener��onClick����
    class BtnGoListener implements OnClickListener{
    	
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		bar.setVisibility(View.VISIBLE);
    		updateBarHandler.post(updateThread);
    		
    	}
    }
    //ʹ�������ڲ�������дhandler��handleMessage����
    Handler updateBarHandler = new Handler(){
    	@Override
    	public void handleMessage(Message msg) {
    		// TODO Auto-generated method stub
//    		super.handleMessage(msg);
    		bar.setProgress(msg.arg1);
    		updateBarHandler.post(updateThread);
    	}
    };
    
    
    //�߳��࣬ʹ�������ڲ���ķ�����������
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
			//�õ�һ����Ϣ����message������androidϵͳ�ṩ
			Message msg = updateBarHandler.obtainMessage();
			//��msg�����arg1������ֵ����Ϊi����arg1��arg2��������Ա����������Ϣ��
			//�ŵ���ϵͳ�������Ľ���
			msg.arg1 = i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//��msg���뵽��Ϣ���е���
			updateBarHandler.sendMessage(msg);
			if (i == 100) {
				updateBarHandler.removeCallbacks(updateThread);
			}
		}
	};
    
    
}
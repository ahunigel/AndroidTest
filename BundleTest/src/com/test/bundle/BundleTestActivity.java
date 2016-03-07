package com.test.bundle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

public class BundleTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //��ӡ��ǰ�̵߳�ID
        System.out.println("Activity---->thread id: "+Thread.currentThread().getId());
        //������һ��HandlerThread����ʵ����ʹ��looper��������Ϣ���еĹ���
        //�������android��Ӧ�ó������ṩ
        HandlerThread handlerThread = new HandlerThread("handler_thread");
        //��ʹ��getLooper����֮ǰ���������������start()����
        handlerThread.start();
        
        MyHandler myHandler = new MyHandler(handlerThread.getLooper());
        Message msg = myHandler.obtainMessage();
        
        //bundle����˵��һ�����ݴ洢����
        Bundle b = new Bundle();
        b.putInt("age", 20);
        b.putString("name", "nigel");
        b.putString("gender", "male");
        msg.setData(b);
        //��Ϣ���󱻷��͵�obtainMessage��Ŀ�����
        msg.sendToTarget();
    }
    
    class MyHandler extends Handler{
    	public MyHandler() {
			// TODO Auto-generated constructor stub
		}
    	//����Ҫ�д˹��캯��
    	public MyHandler(Looper looper) {
    		//��MyHandler�󶨵�looper���ڵ��߳���������Ϣ����
    		super(looper);
    	}
    	@Override
    	public void handleMessage(Message msg) {
    		// TODO Auto-generated method stub
//    		super.handleMessage(msg);
    		Bundle b = msg.getData();
    		int age = b.getInt("age");
    		String gender = b.getString("gender");
    		String name = b.getString("name");
    		String info = "age: "+age +" gender: "+ gender+" name: " + name;
    		System.out.println(info);
    		Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG).show();
            System.out.println("thread id: "+Thread.currentThread().getId());
            System.out.println("handleMessage");
    	}
    }
}
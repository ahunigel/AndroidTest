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
        //打印当前线程的ID
        System.out.println("Activity---->thread id: "+Thread.currentThread().getId());
        //生成了一个HandlerThread对象，实现了使用looper来处理消息队列的功能
        //这个类由android的应用程序框架提供
        HandlerThread handlerThread = new HandlerThread("handler_thread");
        //在使用getLooper方法之前必须先启动该类的start()方法
        handlerThread.start();
        
        MyHandler myHandler = new MyHandler(handlerThread.getLooper());
        Message msg = myHandler.obtainMessage();
        
        //bundle可以说是一个数据存储工具
        Bundle b = new Bundle();
        b.putInt("age", 20);
        b.putString("name", "nigel");
        b.putString("gender", "male");
        msg.setData(b);
        //消息对象被发送到obtainMessage的目标对象
        msg.sendToTarget();
    }
    
    class MyHandler extends Handler{
    	public MyHandler() {
			// TODO Auto-generated constructor stub
		}
    	//必须要有此构造函数
    	public MyHandler(Looper looper) {
    		//把MyHandler绑定到looper所在的线程来处理消息队列
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
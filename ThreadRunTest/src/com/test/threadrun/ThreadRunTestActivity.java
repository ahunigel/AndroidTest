package com.test.threadrun;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class ThreadRunTestActivity extends Activity {
	private Handler handler = new Handler();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //handler是在原有的线程上调用线程run方法，并没有启动一个新线程
        //handler.post(r);
        //java实现线程并启动线程的方法
        Thread t = new Thread(r);
        t.start();
        
        setContentView(R.layout.main);
        
        threadInfoPrint();
//        System.out.println("activity m id: "+Thread.currentThread().getId());
//		System.out.println("activity m name: "+Thread.currentThread().getName());
    }
    
    private void threadInfoPrint() {
		// TODO Auto-generated method stub
        System.out.println("activity id: "+Thread.currentThread().getId());
		System.out.println("activity name: "+Thread.currentThread().getName());
	}

	Runnable r = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			threadInfoPrint();
//	        System.out.println("activity t id: "+Thread.currentThread().getId());
//			System.out.println("activity t name: "+Thread.currentThread().getName());
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
}
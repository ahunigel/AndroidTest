package com.activity.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityLifecycleActivity extends Activity {
	private String actname;
	private Button myButton = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actname = "Main_Activity --- ";
		System.out.println(actname + "OnCreate");
		setContentView(R.layout.main);
		TextView tvmain = (TextView) findViewById(R.id.maintxt);
		tvmain.setText(R.string.hello);
		myButton = (Button) findViewById(R.id.btnSwitch);
		myButton.setText("Go to 2nd Activity");
		myButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent().setClass(
						ActivityLifecycleActivity.this, SecondActivity.class);
				ActivityLifecycleActivity.this.startActivity(intent);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println(actname + "onDestroy");
		super.onDestroy();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		System.out.println(actname + "onPause");
		super.onPause();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		System.out.println(actname + "onRestart");
		super.onRestart();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		System.out.println(actname + "onResume");
		super.onResume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		System.out.println(actname + "onStart");
		super.onStart();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		System.out.println(actname + "onStop");
		super.onStop();
	}

}
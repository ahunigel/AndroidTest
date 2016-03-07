package com.hello.activitiestransfer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelloActivitiesTransfer extends Activity {
	private Button btnNext = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnNext = (Button) findViewById(R.id.button1);
		btnNext.setText("Transfer to next!");
		btnNext.setOnClickListener(new BtnNextListener());
	}

	class BtnNextListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// create an intent object
			Intent intent = new Intent();
			intent.setClass(HelloActivitiesTransfer.this, LinearActivity.class);
			HelloActivitiesTransfer.this.startActivity(intent);

		}

	}
}
package com.hello.activitiestransfer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RelativeActivity extends Activity {
	private Button btnNext = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relativeactivity);
		
		Intent intent01;
		//intent01= new Intent().setClass(this, HelloActivitiesTransfer.class);
		intent01= new Intent();
		intent01.setClass(this, HelloActivitiesTransfer.class);

		btnNext = (Button) findViewById(R.id.button1);
		btnNext.setText("Transfer to next!");
		btnNext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(RelativeActivity.this,
						HelloActivitiesTransfer.class);
				RelativeActivity.this.startActivity(intent);

			}
		});
	}

	class BtnNextListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// create an intent object
			Intent intent = new Intent();
			intent.setClass(RelativeActivity.this,
					HelloActivitiesTransfer.class);
			RelativeActivity.this.startActivity(intent);

		}

	}
}
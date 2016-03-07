package com.hello.activitiestransfer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrameActivity extends Activity{

	private Button btnNext = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frameactivity);

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
			intent.setClass(FrameActivity.this, RelativeActivity.class);
			FrameActivity.this.startActivity(intent);

		}

	}
}
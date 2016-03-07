package com.hello.activitiestransfer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AbsoluteActivity extends Activity{
	private Button btnNext = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.absoluteactivity);
		
		Intent intent = getIntent();
		final String extravalue = intent.getStringExtra("testExtra");
		
		final TextView tvExtra = (TextView) findViewById(R.id.tvIntentExtra);
		Button btnExtra = (Button) findViewById(R.id.btnGetExtra);
		btnExtra.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tvExtra.setText(extravalue);
				
			}
		});

		btnNext = (Button) findViewById(R.id.button1);
		btnNext.setText("Transfer to next!");
		btnNext.setOnClickListener(new BtnNextListener());
	}

	class BtnNextListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// create an intent object
			Intent intent = new Intent().setClass(AbsoluteActivity.this, FrameActivity.class);
			AbsoluteActivity.this.startActivity(intent);

		}

	}
}

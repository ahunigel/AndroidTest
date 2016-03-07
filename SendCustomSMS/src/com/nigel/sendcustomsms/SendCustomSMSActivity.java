package com.nigel.sendcustomsms;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SendCustomSMSActivity extends Activity {

	private Button btnNew = null;
	private Button btnClear = null;
	private Button btnSend = null;
	private Button btnExit = null;
	private EditText txtPhone = null;
	private EditText txtSMS = null;
	private EditText txtName = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms);

		btnNew = (Button) findViewById(R.id.btnNew);
		btnClear = (Button) findViewById(R.id.btnclear);
		btnSend = (Button) findViewById(R.id.send);
		btnExit = (Button) findViewById(R.id.exit);

		txtPhone = (EditText) findViewById(R.id.phonenum);
		txtSMS = (EditText) findViewById(R.id.smscontent);
		txtName = (EditText) findViewById(R.id.myname);

		// System.out.println(txtSMS.getText());
		// TextView txtTest = (TextView) findViewById(R.id.textView1);
		// txtTest.setText(txtSMS.getText());

		btnNew.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				txtSMS.setText("This is a test sms for my new Android application - SendCustomSMS!");
				txtPhone.setText("18991848439");
				txtName.setText("nigel");
			}
		});

		btnClear.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				txtSMS.setText("");
				// txtPhone.setText("");
				// txtName.setText("");
			}
		});

		btnSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String sms = txtSMS.getText().toString() + "\n--from "
						+ txtName.getText().toString();
				Uri uri = Uri.parse("smsto:" + txtPhone.getText());
				Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
				intent.putExtra("sms_body", sms);
				startActivity(intent);

			}
		});

		btnExit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}
}
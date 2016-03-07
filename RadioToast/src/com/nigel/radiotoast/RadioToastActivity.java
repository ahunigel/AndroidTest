package com.nigel.radiotoast;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class RadioToastActivity extends Activity {
	private RadioGroup genderGroup = null;
	private RadioButton maleRadio = null;
	private RadioButton femaleRadio = null;
	private CheckBox codingBox = null;
	private CheckBox travelBox = null;
	private CheckBox swimmingBox = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        genderGroup = (RadioGroup) findViewById(R.id.genderGroup);
        maleRadio = (RadioButton) findViewById(R.id.maleRadio);
        femaleRadio = (RadioButton) findViewById(R.id.femaleRadio);
        codingBox = (CheckBox) findViewById(R.id.codingBox);
        travelBox = (CheckBox) findViewById(R.id.travelBox);
        swimmingBox = (CheckBox) findViewById(R.id.swimmingBox);
        
        genderGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if (maleRadio.getId() == checkedId) {
					System.out.println("male");
					Toast.makeText(RadioToastActivity.this, "male", Toast.LENGTH_SHORT).show();
					
				} else if (femaleRadio.getId() == checkedId) {
					System.out.println("female");
					Toast.makeText(RadioToastActivity.this, "female", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
        
        codingBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					System.out.println(codingBox.getText()+" is checked.");
					Toast.makeText(RadioToastActivity.this, "coding", Toast.LENGTH_SHORT).show();
				} else {
					System.out.println(codingBox.getText()+" is not checked!");
				}
			}
		});
        travelBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					System.out.println(travelBox.getText()+" is checked.");
					Toast.makeText(RadioToastActivity.this, "travel", Toast.LENGTH_SHORT).show();
				} else {
					System.out.println(travelBox.getText()+" is not checked!");
				}
			}
		});
        swimmingBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					System.out.println(swimmingBox.getText()+" is checked.");
					Toast.makeText(RadioToastActivity.this, "swimming", Toast.LENGTH_SHORT).show();
				} else {
					System.out.println(swimmingBox.getText()+" is not checked!");
				}
			}
		});

    }
    
}
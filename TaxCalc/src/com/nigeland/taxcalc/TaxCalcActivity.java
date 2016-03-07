package com.nigeland.taxcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TaxCalcActivity extends Activity {
    /** Called when the activity is first created. */
	EditText salary = null;
	EditText tax = null;
	EditText afterSalary = null;
	Button calc = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        calc = (Button) findViewById(R.id.btnCalc);
        salary = (EditText) findViewById(R.id.Salary);
        tax = (EditText) findViewById(R.id.tax);
        afterSalary = (EditText) findViewById(R.id.afterSalary);
        
        calc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int point = 3500;
				int after = Integer.parseInt(salary.getText().toString())-point;
				System.out.println(after);
				String strTax = "";
				String as = Integer.toString(after);
				tax.setText(strTax);
				afterSalary.setText(as);
			}
		});
    }
}
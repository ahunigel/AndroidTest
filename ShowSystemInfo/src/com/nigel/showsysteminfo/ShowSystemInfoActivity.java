package com.nigel.showsysteminfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ShowSystemInfoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        itemlist = (ListView) findViewById(R.id.itemlist);
        refreshlistitems();
    }

	private void refreshlistitems() {
		// TODO Auto-generated method stub
		
	}
}
package com.hello.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class HelloMenuActivity extends Activity {
	private TextView maintxt;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        maintxt = (TextView) findViewById(R.id.maintext);
    }

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu.ContextMenuInfo)
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, 2, 0, "about");
		menu.add(0, 1, 1, "hello");
		menu.add("exit");
		
		maintxt.setText(R.string.press);
		return super.onCreateOptionsMenu(menu);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		String strItem = (String) item.getTitle();
		switch (item.getItemId()) {
		case 1:
			maintxt.setText(R.string.about);
			break;
		case 2:
			Intent intent = new Intent();
			intent.setClass(HelloMenuActivity.this, AboutMe.class);
			HelloMenuActivity.this.startActivity(intent);
			break;
		default:
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsMenuClosed(android.view.Menu)
	 */
	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
//		maintxt.setText(R.string.hello);
		super.onOptionsMenuClosed(menu);
	}
    
}
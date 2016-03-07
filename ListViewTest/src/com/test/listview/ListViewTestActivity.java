package com.test.listview;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListViewTestActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		HashMap<String, String> map3 = new HashMap<String, String>();
		map1.put("user_name", "nigel");
		map1.put("user_ip", "10.161.66.11");
		map2.put("user_name", "julia");
		map2.put("user_ip", "10.168.13.11");
		map3.put("user_name", "child");
		map3.put("user_ip", "10.168.0.5");
		list.add(map1);
		list.add(map2);
		list.add(map3);

		SimpleAdapter ListAdapter = new SimpleAdapter(this, list,
				R.layout.list, new String[] { "user_name", "user_ip" },
				new int[] { R.id.user_name, R.id.user_ip });
		setListAdapter(ListAdapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.ListActivity#onListItemClick(android.widget.ListView,
	 * android.view.View, int, long)
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		System.out.println("id = " + id + "\nposition = " + position);
		Toast.makeText(getApplicationContext(),
				"id = " + id + "\nposition = " + position, Toast.LENGTH_SHORT)
				.show();
	}
}
package com.test.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.test.sqlite.db.DatabaseHelper;

public class SQLiteTestActivity extends Activity {
	//ѧϰʹ��SQLiteOpenHelper��ʹ�÷�������SQLite��ϵ�����ݿ������ɾ�Ĳ�
    
	private Button btnCreate = null;
	private Button btnUpgrade = null;
	private Button btnInsert = null;
	private Button btnDelete = null;
	private Button btnUpdate = null;
	private Button btnQuery = null;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        findView();
        setParam();
        addListener();
    }

	private void addListener() {
		// TODO Auto-generated method stub
		btnCreate.setOnClickListener(new CreateListener());
		btnUpgrade.setOnClickListener(new UpgradeListener());
		btnInsert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//����ContentValues����
				ContentValues values = new ContentValues();
				//�����ֵ��ʱ������������ֵ��Ҫ���������
				values.put("id", "1");
				values.put("name", "nigel");
//				values.put("id", "2");
//				values.put("name", "julia");
//				values.put("id", "3");
//				values.put("name", "child");
				//����һ��DatabaseHelper����
				DatabaseHelper dbhelper = new DatabaseHelper(SQLiteTestActivity.this, "test_sqlite_db");
				//ֻ�е�����DatabaseHelper�����getReadableDatabase()����getWritableDatabase()����
				SQLiteDatabase db = dbhelper.getWritableDatabase();
				//����insert�������������ݵ�����
				db.insert("user", null, values);
				
			}
		});
		btnDelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//����һ��DatabaseHelper����
				DatabaseHelper dbhelper = new DatabaseHelper(SQLiteTestActivity.this, "test_sqlite_db");
				//ֻ�е�����DatabaseHelper�����getReadableDatabase()����getWritableDatabase()����
				SQLiteDatabase db = dbhelper.getWritableDatabase();
				db.delete("user", "id=?", new String[]{"1"});
			}
		});
		btnUpdate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//����һ��DatabaseHelper����
				DatabaseHelper dbhelper = new DatabaseHelper(SQLiteTestActivity.this, "test_sqlite_db");
				//ֻ�е�����DatabaseHelper�����getReadableDatabase()����getWritableDatabase()����
				SQLiteDatabase db = dbhelper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("name", "ahunigel");
				//����update��������������
				db.update("user", values, "id=?", new String[]{"1"});
				
			}
		});
		btnQuery.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//����һ��DatabaseHelper����
				DatabaseHelper dbhelper = new DatabaseHelper(SQLiteTestActivity.this, "test_sqlite_db");
				//ֻ�е�����DatabaseHelper�����getReadableDatabase()����getWritableDatabase()����
				SQLiteDatabase db = dbhelper.getWritableDatabase();
				
			}
		});
	}

	private void setParam() {
		// TODO Auto-generated method stub
		
	}

	private void findView() {
		// TODO Auto-generated method stub
		btnCreate = (Button) findViewById(R.id.btnCreate);
		btnUpgrade = (Button) findViewById(R.id.btnUpgrade);
		btnInsert = (Button) findViewById(R.id.btnInsert);
		btnDelete = (Button) findViewById(R.id.btnDelete);
		btnUpdate = (Button) findViewById(R.id.btnUpdate);
		btnQuery = (Button) findViewById(R.id.btnQuery);
	}
	
	class CreateListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//����һ��DatabaseHelper����
			DatabaseHelper dbhelper = new DatabaseHelper(SQLiteTestActivity.this, "test_sqlite_db");
			//ֻ�е�����DatabaseHelper�����getReadableDatabase()����getWritableDatabase()����
			SQLiteDatabase db = dbhelper.getReadableDatabase();
			Log.i("Log","Version: "+db.getVersion());
			Toast.makeText(getApplicationContext(), "create a database", Toast.LENGTH_SHORT).show();
			System.out.println("Create database");
			Log.i("Log", "Create database");
		}
	}
	
	class UpgradeListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//����һ��DatabaseHelper����
			DatabaseHelper dbhelper = new DatabaseHelper(SQLiteTestActivity.this, "test_sqlite_db",2);
			//ֻ�е�����DatabaseHelper�����getReadableDatabase()����getWritableDatabase()����
			SQLiteDatabase db = dbhelper.getReadableDatabase();
			Log.i("Log","Version: "+db.getVersion());
		}
	}
}
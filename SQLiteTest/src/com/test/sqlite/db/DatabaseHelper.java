package com.test.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
//DatabaseHelper��Ϊһ������SQLite�������࣬�ṩ��������Ĺ��ܣ�
//1. getReadableDatabase(), getWritableDatabase()���Ի��SQLiteDatebase����
//ͨ���ö�����Զ����ݿ���в���
//2. �ṩonCreate()��onUpgrade()�����ص����������������ڴ������������ݿ�ʱ�������Լ��Ĳ���
	private static int VERSION = 1;
	//��SQLiteOpenHelper�����൱�б���Ҫ�иù��캯��
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		//Context context, String name����, CursorFactory factory����ֵ����,int version��ǰ���ݿ�汾����������
		//����ͨ��super���ø����еĹ��캯��
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	public DatabaseHelper(Context context, String name) {
		this(context,name,VERSION);
	}
	public DatabaseHelper(Context context, String name, int version) {
		this(context,name,null,version);
	}

	//�ú������ڵ�һ�δ������ݿ�ʱ�Ż�ִ�У�ʵ�����ǵ�һ���õ�SQLiteDatebase����ʱ���Ż�����������
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		System.out.println("Create a database");
		Log.i("Log", "Create a database");
		//execSQL��������ִ��sql���
		db.execSQL("create table user (id int, name varchar(20))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		System.out.println("Upgrade a database");
		Log.i("Log", "Upgrade a database");
	}

}

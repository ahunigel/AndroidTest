package com.test.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
//DatabaseHelper作为一个访问SQLite的助手类，提供两个方面的功能：
//1. getReadableDatabase(), getWritableDatabase()可以获得SQLiteDatebase对象
//通过该对象可以对数据库进行操作
//2. 提供onCreate()，onUpgrade()两个回调函数，允许我们在创建和升级数据库时，进行自己的操作
	private static int VERSION = 1;
	//在SQLiteOpenHelper的子类当中必须要有该构造函数
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		//Context context, String name表名, CursorFactory factory传空值即可,int version当前数据库版本，正数递增
		//必须通过super调用父类中的构造函数
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	public DatabaseHelper(Context context, String name) {
		this(context,name,VERSION);
	}
	public DatabaseHelper(Context context, String name, int version) {
		this(context,name,null,version);
	}

	//该函数是在第一次创建数据库时才会执行，实际上是第一个得到SQLiteDatebase对象时，才会调用这个方法
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		System.out.println("Create a database");
		Log.i("Log", "Create a database");
		//execSQL方法用于执行sql语句
		db.execSQL("create table user (id int, name varchar(20))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		System.out.println("Upgrade a database");
		Log.i("Log", "Upgrade a database");
	}

}

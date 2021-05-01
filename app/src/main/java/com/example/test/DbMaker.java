package com.example.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbMaker extends SQLiteOpenHelper {
    DbMaker(Context context){
        super(context,"DB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table todo(id integer primary key autoincrement,title text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

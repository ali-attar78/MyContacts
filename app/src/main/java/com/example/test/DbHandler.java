package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbHandler {
    SQLiteDatabase database;
    DbMaker dbMaker;
    Context context;

   public DbHandler(Context context){
       this.context=context;
      dbMaker = new DbMaker(context);

   }

   public void open(){
       database=dbMaker.getWritableDatabase();
   }
public void close(){
       database.close();
}


public void insert(String title){
    ContentValues contentValues = new ContentValues();
contentValues.put("title",title);
database.insert("todo", (String) null ,contentValues);

}




public void delete(String user){
database.delete("todo","title"+"=?",new String[]{user});


}




public void update(String oldContact,String newContact){
    ContentValues contentValues = new ContentValues();
    contentValues.put("title",newContact);

       database.update("todo",contentValues,"title"+"=?",new String[]{oldContact});

}





public String[] getAllTodo(){

    Cursor cursor= database.rawQuery("SELECT title FROM todo WHERE 1 ",null);
String[] strings = new String[cursor.getCount()];
cursor.moveToFirst();

for (int i=0;i < cursor.getCount();i++){
    strings[i] = cursor.getString(0);
    cursor.moveToNext();
}
cursor.close();
return strings;
}


}

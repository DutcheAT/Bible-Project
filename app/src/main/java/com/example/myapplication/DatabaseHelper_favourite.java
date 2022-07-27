package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper_favourite extends SQLiteOpenHelper {
    public DatabaseHelper_favourite(@Nullable Context context) {
        super(context,"Bible_Database2",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Bible_favourite(title TEXT PRIMARY KEY,content TEXT,image TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Bible_favourite");

    }
    public boolean insert_favourites(String title,String content,String image){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put("title",title);
        cv.put("content",content);
        cv.put("image",image);

        long res=db.insert("Bible_favourite",null,cv);
        if(res==-1){
            return false;
        }
        else{
            return true;
        }

    }
    public Cursor Read_favourites(){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from Bible_favourite",null);

        return c;
    }
    public Cursor Read_favourites_using_title(String  title){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from Bible_favourite WHERE title=?",new String[]{title});

        return c;
    }
    public boolean delete_favourites(String title){

        SQLiteDatabase db = this.getWritableDatabase();
        int d=db.delete("Bible_favourite","title=?",new String[]{title});

        if(d>0){
            return true;
        }
        else{
            return false;
        }

    }
}

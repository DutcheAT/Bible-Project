package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.Size;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(@Nullable Context context) {
        super(context,"Bible_Database",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Bible_font(counter TEXT PRIMARY KEY,size NUMBER)");
        //db.execSQL("CREATE TABLE Bible_favourite(title TEXT PRIMARY KEY,content TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Bible_font");

    }

    public boolean insert_font_size(int size){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put("size",size);
        cv.put("counter","1");

        long res=db.insert("Bible_font",null,cv);
        if(res==-1){
            return false;
        }
        else{
            return true;
        }

    }

//To retrieve data from database

    public Cursor Read_sizs(){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from Bible_font",null);

        return c;
    }


    public boolean updateFont(int size) {


        ContentValues cv=new ContentValues();
        cv.put("size",size);

        SQLiteDatabase db=this.getWritableDatabase();
        int x=db.update("Bible_font",cv,"counter=?",new String[]{"1"});

        if(x>0){
            return true;
        }
        else{
            return false;
        }

    }



}



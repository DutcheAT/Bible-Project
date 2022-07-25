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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Bible_font");

    }

    //to insert data to database
    public boolean insert_font_size(){

//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("name",name);
//        cv.put("password",pass);
//        //cv.put("DEPARTMENT",department);
//
//        long Result = db.insert("student_detail2",null,cv);
//
//        if(Result==-1){
//            return false;
//        }
//        else{
//            return  true;
//        }
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
       int size=25;
        cv.put("size",size);
        cv.put("counter","1");
        //cv.put("password",pass);

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

//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("Select * from student_detail",null);
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from Bible_font",null);

        return c;
    }

//    public Cursor ViewStudentInfo2(String name, String pass){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.rawQuery("Select * from student_detail2 where name=? and password=?",new String[]{name,pass});
//
//        return cursor;
//    }

    public boolean updateStudentInfo(int size) {


//            String unamei=null;
//            String pwdi=null;
//            SQLiteDatabase db = this.getWritableDatabase();
//            Cursor cursor = db.rawQuery("SELECT *FROM student_detail2",null);
//            while(cursor.moveToNext()) {
//                unamei = cursor.getString(0);
//                pwdi = cursor.getString(1);
//            }
//            if(name.equals(unamei) && pass.equals(pwdi)){
//                return true;
//            }
//            else{
//                return false;
//            }
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





//        boolean returnV=false;
//
//        try {
//            int updated = db.update("student_detail", cv, "where student_id =" + id, null);
//            if (updated == -1) {
//                returnV=false;
//            } else {
//                returnV=true;
//            }
//        } catch (Exception e) {
//
//        }
//
//        return returnV;
    }
    public boolean deleteStudentInfo(String pass){

        SQLiteDatabase db = this.getWritableDatabase();
        int d=db.delete("student_detail2","password=?",new String[]{pass});

        if(d>0){
            return true;
        }
        else{
            return false;
        }



//        int deleted = db.delete("student_detail","student_id="+id,null);
//        if(deleted==-1){
//            return false;
//        }
//        else{
//            return true;
//        }
    }

    public boolean login(String name, String pass){
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor c=db.rawQuery("select * from student_detail2 where name=? and password=?",new String[]{name,pass});

        int x=c.getCount();
        if(x==0){
            return false;
        }
        else{
            return true;
        }
    }


}



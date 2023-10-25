package com.lokesh.loginsignup.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.lokesh.loginsignup.self_define.hashCode;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {


    private static final  String DATABASE_NAME= "Appdatabase";
    private static final  int DATABASE_VERSION = 2;
    private static final String TableName = "userdetail";
    private static final String TableName2 = "notesdetail";

    public DataBaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TableName+" (\n" +
                "    First_Name TEXT,\n" +
                "    Last_Name TEXT ,\n" +
                "    Email TEXT,\n" +
                "    Phone_No TEXT,\n" +
                "    Username TEXT PRIMARY KEY NOT NULL,\n" +
                "    Password TEXT\n" +
                ")");








    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TableName);
            onCreate(sqLiteDatabase);


    }

    public void insertUser(String First_Name, String Last_Name, String Email,String Phone_No,
                              String Username,String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("First_Name",First_Name);
        values.put("Last_Name",Last_Name);
        values.put("Email",Email);
        values.put("Phone_No",Phone_No);
        values.put("Username",Username);
        values.put("Password",Password);
        db.insert(TableName,null,values);
    }


    public  void updateUser(userEntity item ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("First_Name",item.getFirst_name());
        values.put("Last_Name",item.getLast_name());
        values.put("Email",item.getEmail());
        values.put("Phone_No",item.getPhone_no());
        db.update(TableName,values,"Username =?",new String[]{item.getUsername()});

    }



    public void updateUserPassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Password",password);
        db.update(TableName,values,"Username =?",new String[]{username});
    }

    public void userDelete(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TableName,"Username =?",new String[]{username});
    }


    public List<userEntity> getAllUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TableName;
        Cursor cursor = db.rawQuery(query,null);

        List<userEntity> userList = new ArrayList<>();

        while (cursor.moveToNext()) {
            String Username = cursor.getString(cursor.getColumnIndex("Username"));
            String First_Name = cursor.getString(cursor.getColumnIndex("First_Name"));
            String Last_Name = cursor.getString(cursor.getColumnIndex("Last_Name"));
            String Email = cursor.getString(cursor.getColumnIndex("Email"));
            String Phone_No = cursor.getString(cursor.getColumnIndex("Phone_No"));
            String Password = cursor.getString(cursor.getColumnIndex("Password"));
            userEntity user = new userEntity(First_Name,Last_Name,Email,Phone_No,Username,Password);
            userList.add(user);
        }
        cursor.close();

        return userList;

    }


    public boolean checkUsername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TableName+" WHERE Username =?";
        Cursor cursor = db.rawQuery(query,new String[]{username});

        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TableName+" WHERE Username =? AND Password =?";
        Cursor cursor = db.rawQuery(query,new String[]{username,password});

        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }






}

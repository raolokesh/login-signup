package com.lokesh.loginsignup.database;


import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DataBaseHelper extends SQLiteOpenHelper {


    private static final  String DATABASE_NAME= "Appdatabase";
    private static final  int DATABASE_VERSION = 1;
    public static final String TableName = "userdetail";
    public static final String TableName2 = "notesdetail";

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

        db.execSQL("CREATE TABLE IF NOT EXISTS "+TableName2+" (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "    Title TEXT,\n" +
                "    Description TEXT,\n" +
                "    Date TEXT,\n" +
                "    userId TEXT,\n" +
                "    FOREIGN KEY (userId) REFERENCES userdetail(Username) ON DELETE CASCADE\n" +
                ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TableName);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TableName2);
            onCreate(sqLiteDatabase);


    }



}

package com.lokesh.loginsignup.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class notesHelper extends SQLiteOpenHelper {

    private static final  String DATABASE_NAME= "Appdatabase";
    private static final  int DATABASE_VERSION = 2;
    private static final String TableName2 = "notesdetail";


    public notesHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
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

    }


    public void insertnotes(String Title, String Description, String Date,String userId  ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Title",Title);
        values.put("Description",Description);
        values.put("Date",Date);
        values.put("userId",userId);
        db.insert(TableName2,null,values);
    }

    public void updatenotes(notesEntity entity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",entity.getId());
        values.put("Title",entity.getTitle());
        values.put("Description",entity.getDescription());
        values.put("Date",entity.getDate());
        values.put("userId",entity.getUserId());
        db.update(TableName2, values, "id = ?", new String[] { String.valueOf(entity.getId()) });

    }

    public List<notesEntity> getnotes(String userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<notesEntity> list =  new ArrayList<notesEntity>();
        String query = "SELECT * FROM "+TableName2+" WHERE userId =?";
        Cursor cursor = db.rawQuery(query,new String[]{userId});


        while (cursor.moveToNext()) {
            notesEntity entity = new notesEntity(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            list.add(entity);
        }
        cursor.close();

        return list;
    }

}

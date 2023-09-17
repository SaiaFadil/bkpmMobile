package com.example.implementasisqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLClientInfoException;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table biodata(no integer primary key,nama text null,tgl text null,jk text null,alamat text null);";
        Log.d("Data","onCreate"+sql);
                db.execSQL(sql);
        sql = "insert into biodata(no,nama,tgl,jk,alamat) Values('1','Fadillah wahyu nugraha','2004-02-27','L','Nganjuk');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}

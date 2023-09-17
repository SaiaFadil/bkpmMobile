package com.example.implementasisqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatBiodata extends AppCompatActivity {

    protected Cursor cursor;
    Button ton1,ton2;
    DatabaseHelper dbHelper;
    EditText text1,text2,text3,text4,text5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);
        dbHelper = new DatabaseHelper(this);
        text1 = findViewById(R.id.editText1);
        text2 = findViewById(R.id.editText2);
        text3 = findViewById(R.id.editText3);
        text4 = findViewById(R.id.editText4);
        text5 = findViewById(R.id.editText5);
        ton1 = findViewById(R.id.button1);
        ton2 = findViewById(R.id.button2);


        ton1.setOnClickListener((arg0) -> {
            try {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into biodata(no,nama,tgl,jk,alamat) values('"+
                        text1.getText().toString() + "','"+
                        text2.getText().toString() + "','"+
                        text3.getText().toString() + "','"+
                        text4.getText().toString() + "','"+
                        text5.getText().toString() +"')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Gagal menambahkan data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        ton2.setOnClickListener((arg0)->{
            finish();
        });
    }
}
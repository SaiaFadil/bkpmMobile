package com.example.implementasisqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DatabaseHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        dbHelper = new DatabaseHelper(this);
        text1 = findViewById(R.id.editText1);
        text2 = findViewById(R.id.editText2);
        text3 = findViewById(R.id.editText3);
        text4 = findViewById(R.id.editText4);
        text5 = findViewById(R.id.editText5);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '"+
                getIntent().getStringExtra("nama")+"'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        ton1 = findViewById(R.id.button1);
        ton2 = findViewById(R.id.button2);

        ton1.setOnClickListener((arg0) -> {
            try {
                SQLiteDatabase dbw = dbHelper.getWritableDatabase();
                dbw.execSQL("UPDATE biodata SET nama='" +
                        text2.getText().toString() + "',tgl = '" +
                        text3.getText().toString() + "',jk = '" +
                        text4.getText().toString() + "',alamat = '" +
                        text5.getText().toString() + "' WHERE no = '" +
                        text1.getText().toString() + "'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Gagal: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        ton2.setOnClickListener((arg0) -> {
            finish();
        });
    }
}

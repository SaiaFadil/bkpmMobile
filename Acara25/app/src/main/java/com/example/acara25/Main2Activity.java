package com.example.acara25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showText = findViewById(R.id.getText);
    }

    public void back(View view) {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }

    public void getPublic(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder, "myData1.txt"); // Ubah nama file sesuai dengan yang Anda gunakan di MainActivity
        String text = getData(myFile);
        if (text != null) {
            showText.setText(text);
        } else {
            showText.setText("No Data");
        }
    }

    public void getPrivate(View view) {
        File folder = getExternalFilesDir("arvita"); // Ubah nama folder sesuai dengan yang Anda gunakan di MainActivity
        File myFile = new File(folder, "myData2.txt"); // Ubah nama file sesuai dengan yang Anda gunakan di MainActivity
        String text = getData(myFile);
        if (text != null) {
            showText.setText(text);
        } else {
            showText.setText("No Data");
        }
    }


 //kode di bawah sesuai bkpm dan error

//    public void getPublic(View view) {
//        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        File myFile = new File(folder, "myData1.txt"); // Ubah nama file sesuai dengan yang Anda gunakan di MainActivity
//        String text = getData(myFile);
//        if (text != null) {
//            showText.setText(text);
//        } else {
//            showText.setText("No Data");
//        }
//    }
//
//    public void getPrivate(View view) {
//        File folder = getExternalFilesDir("arvita"); // Ubah nama folder sesuai dengan yang Anda gunakan di MainActivity
//        File myFile = new File(folder, "myData2.txt"); // Ubah nama file sesuai dengan yang Anda gunakan di MainActivity
//        String text = getData(myFile);
//        if (text != null) {
//            showText.setText(text);
//        } else {
//            showText.setText("No Data");
//        }
//    }



    private String getData(File myFile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myFile);
            int i;
            StringBuilder buffer = new StringBuilder();
            while ((i = fileInputStream.read()) != -1) {
                buffer.append((char) i);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

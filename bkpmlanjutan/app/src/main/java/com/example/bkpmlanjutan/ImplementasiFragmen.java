package com.example.bkpmlanjutan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;


//import di bwh yang sesuai bkpm tidak lagi di pake karena menggunakan versi android studio yang lama

//import android.app.FragmentTransaction;
//import android.app.FragmentManager;
//import android.app.Fragment;

public class ImplementasiFragmen extends AppCompatActivity {
Button btnFirstFragment,btnSecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implementasi_fragmen);

        btnFirstFragment = findViewById(R.id.firstFragment);
        btnSecondFragment = findViewById(R.id.secondFragment);

        btnFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FirstFragment());
            }
        });
        btnSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new SecondFragment());
            }
        });


    }
    private void loadFragment(Fragment fragment){

          FragmentManager fm = getSupportFragmentManager();
        //FragmentManager fm = getFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}
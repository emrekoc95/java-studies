package com.kocemre.javafragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void fragmentChange (int containerViewId, Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(containerViewId,fragment).commit();
    }

    public void goToFirst(View view){
        FirstFragment firstFragment = new FirstFragment();
        fragmentChange(R.id.frame_layout,firstFragment);

    }

    public void goToSecond(View view){
        SecondFragment secondFragment = new SecondFragment();
        fragmentChange(R.id.frame_layout,secondFragment);

    }
}
package com.kocemre.landmarkbookjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kocemre.landmarkbookjava.databinding.ActivityDetailBinding;
import com.kocemre.landmarkbookjava.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    Landmark sentLandmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Singleton singleton = Singleton.getInstance();
        sentLandmark = singleton.getSentLandmark();


        binding.nameText.setText(sentLandmark.name);
        binding.countryText.setText(sentLandmark.country);
        binding.imageView.setImageResource(sentLandmark.image);


    }
}
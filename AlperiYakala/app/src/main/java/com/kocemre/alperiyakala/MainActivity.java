package com.kocemre.alperiyakala;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView scoreText;
    TextView timerText;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageViewArray;
    int score;
    int time;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreText = findViewById(R.id.scoreText);
        timerText = findViewById(R.id.timerText);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageViewArray = new ImageView[]{imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};
        score = 0;
        time = 20;
        hideImage();

        new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                time--;
                timerText.setText("Süre: " + time);
            }

            @Override
            public void onFinish() {
                timerText.setText("Zaman Doldu!");
                handler.removeCallbacks(runnable);
                for (ImageView i : imageViewArray) {
                    i.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setMessage("Yeniden oynamak ister misiniz?");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Runtime.getRuntime().exit(0);
                    }
                });
                alert.show();
            }


        }.start();
    }

    public void score(View a) {
        score++;
        scoreText.setText("Puan: " + score);

    }

    public void hideImage() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView i : imageViewArray) {
                    i.setVisibility(View.INVISIBLE);
                }

                Random random = new Random();
                int i = random.nextInt(8);
                imageViewArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 500);

            }
        };

        handler.post(runnable);


    }


}

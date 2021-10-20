package com.example.tpandroid;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static com.example.tpandroid.R.drawable.google_logo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button btnChangeStyle;
    private Button btnReplaySound;
    private Button btnNextPage;
    private ImageView imageView;
    private int styleNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangeStyle = findViewById(R.id.btnChangeStyle);
        btnReplaySound = findViewById(R.id.btnReplaySound);
        btnNextPage = findViewById(R.id.btnNextPage);
        imageView = findViewById(R.id.imageView);

        btnChangeStyle.setOnClickListener(btnChangeStyleListener);
        btnNextPage.setOnClickListener(btnNextPageListener);
        btnReplaySound.setOnClickListener(btnReplaySoundListener);



        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.roulement_de_tambour);
        mPlayer.start();
    }

    private View.OnClickListener btnNextPageListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Log.i("DEBUG", "Bouton cliqué Next Page");

            Intent intent = new Intent(
                    MainActivity.this,
                    Activity2.class
            );
            startActivity(intent);

        }
    };

    private View.OnClickListener btnChangeStyleListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Log.i("DEBUG", "Bouton cliqué Change Style");
            if(styleNum == 0) {
                imageView.setImageResource(google_logo);
                btnChangeStyle.setBackgroundColor(RED);
                btnReplaySound.setBackgroundColor(BLUE);
                btnNextPage.setBackgroundColor(GREEN);
                styleNum = 1;
            } else {
                imageView.setImageResource(R.drawable.android_logo_660x330);
                btnChangeStyle.setBackgroundColor(BLACK);
                btnReplaySound.setBackgroundColor(BLACK);
                btnNextPage.setBackgroundColor(BLACK);
                styleNum = 0;
            }
        }
    };

    private View.OnClickListener btnReplaySoundListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Log.i("DEBUG", "Bouton cliqué Replay Sound");

            MediaPlayer mPlayer = MediaPlayer.create(view.getContext(), R.raw.roulement_de_tambour);
            mPlayer.start();
        }
    };
}
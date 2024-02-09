package com.example.exgam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PCount extends AppCompatActivity {
    MediaPlayer click;
    Button onep, twop;
    MediaPlayer laug;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcount);
        onep = (Button) findViewById(R.id.FlashBtn);
        twop = (Button) findViewById(R.id.SoundBtn);
    }
    public void single(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        Intent go = new Intent(this, GameSelectOP.class);
        startActivity(go);
    }
    public void multi(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        Intent go = new Intent(this, TPNames.class);
        startActivity(go);
    }
    public void laugh(View view){
        laug = MediaPlayer.create(this, R.raw.kiralaughlong);
        laug.start();
    }
}
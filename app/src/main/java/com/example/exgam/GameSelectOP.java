package com.example.exgam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class GameSelectOP extends AppCompatActivity {
    MediaPlayer click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select_op);
    }
    public void guss (View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        Intent go = new Intent(this, GuessNumberOP.class);
        startActivity(go);
    }
    public void rpsop (View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        Intent go = new Intent(this, RPSOP.class);
        startActivity(go);
    }
}
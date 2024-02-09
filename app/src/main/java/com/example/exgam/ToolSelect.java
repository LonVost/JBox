package com.example.exgam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class ToolSelect extends AppCompatActivity {
    MediaPlayer click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_select);
    }
    public void Sound(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        Intent go = new Intent(this,Sound.class);
        startActivity(go);
    }
    public void Flash(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        Intent go = new Intent(this,Flash.class);
        startActivity(go);
    }
    public void Vibra(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        Intent go = new Intent(this,Vibrate.class);
        startActivity(go);
    }
}
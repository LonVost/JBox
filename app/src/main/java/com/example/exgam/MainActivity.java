package com.example.exgam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
Button onep, twop;
MediaPlayer laug,click;
int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onep = (Button) findViewById(R.id.FlashBtn);
        twop = (Button) findViewById(R.id.SoundBtn);
    }
    public void game(View view){
        click = MediaPlayer.create(MainActivity.this, R.raw.p5click);
        click.start();
        Intent go = new Intent(this, PCount.class);
        startActivity(go);
    }
    public void tool(View view){
        click = MediaPlayer.create(MainActivity.this, R.raw.p5click);
        click.start();
        Intent go = new Intent(this, ToolSelect.class);
        startActivity(go);
    }
    public void laugh(View view){
        if(a==0) {
            laug = MediaPlayer.create(MainActivity.this, R.raw.kiralaughlong);
            laug.start();
            a++;
        }
        else{
            laug.stop();
            a--;
        }
    }
    public void music(View view){
        click = MediaPlayer.create(MainActivity.this, R.raw.p5click);
        click.start();
        try {
        Intent go = getPackageManager().getLaunchIntentForPackage("com.google.android.music");
        startActivity(go);
    }
    catch (Exception e){
        Toast t = Toast.makeText(getApplicationContext(),
                "App is not found", Toast.LENGTH_SHORT);
        t.show();
        e.printStackTrace();
    }
    }
    public void camera(View view){
        click = MediaPlayer.create(MainActivity.this, R.raw.p5click);
        click.start();
        try {
            Intent go = getPackageManager().getLaunchIntentForPackage("com.android.camera2");
            startActivity(go);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast t = Toast.makeText(getApplicationContext(),
                    "App is not found", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}
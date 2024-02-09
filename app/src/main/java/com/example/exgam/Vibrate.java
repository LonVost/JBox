package com.example.exgam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.os.Vibrator;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class Vibrate extends AppCompatActivity {
MediaPlayer click;
    ToggleButton toggleVibrateOnOff;
    ImageView vib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        toggleVibrateOnOff = findViewById(R.id.OCBtn);
        vib = findViewById(R.id.SoundImg);
    }
    public void finish(){
        super.finish();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.cancel();
    }
    public void Vibrate(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (toggleVibrateOnOff.isChecked()){
                v.vibrate(40000000);
                vib.setImageResource(R.drawable.vibratek);
        }
        else{
            v.cancel();
            vib.setImageResource(R.drawable.vibrateg);
        }
    }
}
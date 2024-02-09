package com.example.exgam;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Sound extends AppCompatActivity {

    ToggleButton toggleSoundOnOff;
    MediaPlayer soun;
    ImageView sounImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        sounImg = findViewById(R.id.SoundImg);
        toggleSoundOnOff = findViewById(R.id.OCBtn);
    }
    public void finish(){
        super.finish();
        if (toggleSoundOnOff.isChecked()) {
            soun.stop();
        }
    }
    public void Sound(View view){
        if (toggleSoundOnOff.isChecked()){
            soun = MediaPlayer.create(this, R.raw.p5lastsuprize);
            soun.start();
            sounImg.setImageResource(R.drawable.soundk);
        }
        else{
            soun.stop();
            sounImg.setImageResource(R.drawable.soundg);
        }
    }
}
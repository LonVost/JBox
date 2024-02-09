package com.example.exgam;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Flash extends AppCompatActivity {
    ToggleButton fls;
    ImageView flashimg;
    boolean check;
    private ToggleButton toggleFlashLightOnOff;
    private CameraManager cameraManager;
    private String getCameraID;
    MediaPlayer click;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        flashimg = (ImageView) findViewById(R.id.SoundImg);
        toggleFlashLightOnOff = findViewById(R.id.OCBtn);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            getCameraID = cameraManager.getCameraIdList()[0];
        }
        catch (CameraAccessException e) {
            e.printStackTrace();
        }
       }

    public void finish(){
        super.finish();
            Toast.makeText(this, "Flashlight is turned OFF", Toast.LENGTH_SHORT).show();
    }
    public void Flash(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        if (toggleFlashLightOnOff.isChecked()){
            try{
                cameraManager.setTorchMode(getCameraID,true);
                Toast.makeText(this,"Flashlight is turned ON",Toast.LENGTH_SHORT);
                flashimg.setImageResource(R.drawable.flashk);
            }
            catch (CameraAccessException e){
                e.printStackTrace();
            }
        }
        else{
            try{
                cameraManager.setTorchMode(getCameraID,false);
                Toast.makeText(this,"Flashlight is turned OFF",Toast.LENGTH_SHORT);
                flashimg.setImageResource(R.drawable.flashg);
            }
            catch (CameraAccessException e){
                e.printStackTrace();
            }
        }
        }
}

package com.example.exgam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameSelectTP extends AppCompatActivity {
ImageView log;
    MediaPlayer click;
    TextView p1,p2,k1,k2;
    String p11,p22,k11,k22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent verial = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select_tp);
        log = (ImageView) findViewById(R.id.LogImg);
        p1 = (TextView) findViewById(R.id.p1Txt);
        p2 = (TextView) findViewById(R.id.p2Txt);
        k1 = (TextView) findViewById(R.id.p1kTxt);
        k2 = (TextView) findViewById(R.id.p2kTxt);
        p1.setText(verial.getStringExtra("joker1"));
        p2.setText(verial.getStringExtra("joker2"));
        k1.setText(verial.getStringExtra("p1kira"));
        k2.setText(verial.getStringExtra("p2kira"));
        p11 = p1.getText().toString();
        k11 = k1.getText().toString();
        p22 = p2.getText().toString();
        k22 = k2.getText().toString();
       // if(p2.equals("Kira")) {
           // log.setImageResource(R.drawable.kira);
            //log.setScaleType(ImageView.ScaleType.MATRIX);
        //}
        //else if (p1.equals("Kira")){
           // log.setImageResource(R.drawable.kira);
           // log.setScaleType(ImageView.ScaleType.MATRIX);
        //}
    }
    public void gamenum(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        Intent go = new Intent(this,GuessNumberTP.class);
        go.putExtra("joker1",p11);
        go.putExtra("joker2",p22);
        go.putExtra("p1kira",k11);
        go.putExtra("p2kira",k22);
        startActivity(go);
    }
}
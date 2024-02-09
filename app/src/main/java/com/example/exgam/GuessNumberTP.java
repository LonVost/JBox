package com.example.exgam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

public class GuessNumberTP extends AppCompatActivity {

    Button oneb,twob,threeb,fourb,fiveb,sixb,sevenb,eightb,nineb,zerob,restb,gueb,gameres;
    TextView min,max,name,check;
    EditText say;
    int bomb, tur = 0, minsay = 1,maxsay = 100,psay;;
    String p1,p2,p1k,p2k;
    MediaPlayer click;
    //boolean tur = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_number_tp);
        Intent veri = getIntent();
        oneb = (Button) findViewById(R.id.oneBTN);
        twob = (Button) findViewById(R.id.twoBTN);
        threeb = (Button) findViewById(R.id.threeBTN);
        fourb = (Button) findViewById(R.id.fourBTN);
        fiveb = (Button) findViewById(R.id.fiveBTN);
        sixb = (Button) findViewById(R.id.sixBTN);
        sevenb = (Button) findViewById(R.id.sevenBTN);
        eightb = (Button) findViewById(R.id.eightBTN);
        nineb = (Button) findViewById(R.id.nineBTN);
        zerob = (Button) findViewById(R.id.zeroBTN);
        restb = (Button) findViewById(R.id.restBTN);
        gueb = (Button) findViewById(R.id.GuessBTN);
        min = (TextView) findViewById(R.id.MinTxt);
        max = (TextView) findViewById(R.id.MaxTxt);
        check = (TextView) findViewById(R.id.chekTxt);
        name = (TextView) findViewById(R.id.NameTxt);
        say = (EditText) findViewById(R.id.NumberTXT);
        gameres = (Button) findViewById(R.id.restGameBtn);
        p1=veri.getStringExtra("joker1");
        p2=veri.getStringExtra("joker2");
        p1k=veri.getStringExtra("p1kira");
        p2k=veri.getStringExtra("p2kira");
        //name.setText("kira");
        name.setText(p1);
        bomb = ThreadLocalRandom.current().nextInt(1, 101);
    }
    public void restg(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        tur=0;
        bomb = ThreadLocalRandom.current().nextInt(1, 101);
        min.setText("1");
        max.setText("100");
        name.setText(p1.toString());
        gameres.setVisibility(View.INVISIBLE);
        say.setText("");
        say.setVisibility(View.VISIBLE);
    }
    public void gueq(View view){
        try{
            psay = Integer.parseInt(say.getText().toString());
                if (say.getVisibility() == View.VISIBLE) {
                    //minsay = 1;
                    //maxsay = 100;
                    String mi, mx;
                    if (psay <= minsay) {
                        say.setText("");
                        say.setHint("");
                    } else if (psay >= maxsay) {
                        say.setText("");
                        say.setHint("");
                    } else if (psay < bomb) {
                        if (psay >= bomb - 10) {
                            click = MediaPlayer.create(this, R.raw.beepbutton);
                            click.start();
                        }
                        mi = mx = say.getText().toString();
                        min.setText(mi.toString());
                        minsay = psay;
                        // tur++;
                        if (tur == 1) {
                            tur--;
                            name.setText(p1.toString());
                        } else {
                            tur++;
                            name.setText(p2.toString());
                        }
                        say.setText("");
                    } else if (psay > bomb) {
                        if (psay <= bomb + 10) {
                            click = MediaPlayer.create(this, R.raw.beepbutton);
                            click.start();
                        }
                        mx = say.getText().toString();
                        max.setText(mx.toString());
                        maxsay = psay;
                        // tur++;
                        if (tur == 1) {
                            tur--;
                            name.setText(p1.toString());
                        } else {
                            tur++;
                            name.setText(p2.toString());
                        }
                        say.setText("");
                    } else {
                        click = MediaPlayer.create(this, R.raw.gameover);
                        click.start();
                        say.setText("");
                        say.setVisibility(View.INVISIBLE);
                        name.setText(name.getText() + "\nLose");
                        tur = 5;
                        gameres.setVisibility(View.VISIBLE);
                    }
                }
                else {

                }
        }
        catch (Exception e){
            Toast t = Toast.makeText(getApplicationContext(),
                    "Write a number", Toast.LENGTH_SHORT);
            t.show();
            e.printStackTrace();
        }

    }
    public void reset(View view){
        say.setText("");
        click = MediaPlayer.create(this, R.raw.clickbutton);
        click.start();
    }
    public void zero(View view){
        say.setText(say.getText()+"0");
        click = MediaPlayer.create(this, R.raw.clickbutton);
        click.start();
    }
    public void one(View view){
        say.setText(say.getText()+"1");
        click = MediaPlayer.create(this, R.raw.clickbutton);
        click.start();
    }
    public void two(View view){
        say.setText(say.getText()+"2");
        click = MediaPlayer.create(this, R.raw.clickbutton);
        click.start();
    }
    public void three(View view){
        say.setText(say.getText()+"3");
        click = MediaPlayer.create(this, R.raw.clickbutton);
        click.start();
    }
    public void four(View view){
        say.setText(say.getText()+"4");
        click = MediaPlayer.create(this, R.raw.clickbutton);
        click.start();
    }
    public void five(View view){
        say.setText(say.getText()+"5");
        click = MediaPlayer.create(this, R.raw.clickbutton);
        click.start();
    }
    public void six(View view){
        say.setText(say.getText()+"6");
        click = MediaPlayer.create(this, R.raw.clickbutton);
        click.start();
    }
    public void seven(View view){
        say.setText(say.getText()+"7");
        click = MediaPlayer.create(this, R.raw.clickbutton);
        click.start();
    }
    public void eight(View view){
        say.setText(say.getText()+"8");
        click = MediaPlayer.create(this, R.raw.clickbutton);
        click.start();
    }
    public void nine(View view){
        say.setText(say.getText()+"9");
        click = MediaPlayer.create(this, R.raw.clickbutton);
        click.start();
    }
}
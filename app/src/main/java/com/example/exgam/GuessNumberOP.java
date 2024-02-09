package com.example.exgam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

public class GuessNumberOP extends AppCompatActivity {
    Button oneb,twob,threeb,fourb,fiveb,sixb,sevenb,eightb,nineb,zerob,restb,gueb,gameres,bjoker,ujoker,bhealt,uhealt,bmove,umove;
    TextView min,max,move,pointt,check,levtx;
    EditText say;
    int num, moveS = 5, minsay = 1,maxsay = 10,psay,jkr=0,hlt=0,mov=0,poin=0,lvl=1,moveSc=5,a;
    MediaPlayer click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_number_op);
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
        say = (EditText) findViewById(R.id.NumberTXT);
        gameres = (Button) findViewById(R.id.restGameBtn);
        bjoker = (Button) findViewById(R.id.buyJokerBtn);
        ujoker = (Button) findViewById(R.id.jokeruseBtn);
        bmove = (Button) findViewById(R.id.BuyMoveBtn);
        umove = (Button) findViewById(R.id.moveuseBtn);
        bhealt = (Button) findViewById(R.id.buyHealtBtn);
        uhealt = (Button) findViewById(R.id.healtuseBtn);
        move = (TextView) findViewById(R.id.MoveTXT);
        pointt = (TextView) findViewById(R.id.pointTXT);
        levtx = (TextView) findViewById(R.id.lvlTXT);
        move.setText("Move: "+moveS);
        levtx.setText("Level "+lvl);
        pointt.setText("Point: "+poin);
        num = ThreadLocalRandom.current().nextInt(1, 11);
    }
    public void buyMove(View view){
        if (poin >=100) {
            click = MediaPlayer.create(this, R.raw.p5click);
            click.start();
            poin = poin - 100;
            mov++;
            umove.setText("Use: " + mov);
            pointt.setText("Point: "+poin);
        }
    }
    public void buyHealt(View view){
        if (poin >=500) {
            click = MediaPlayer.create(this, R.raw.p5click);
            click.start();
            poin = poin - 500;
            hlt++;
            uhealt.setText("Use: " + hlt);
            pointt.setText("Point: "+poin);
        }
    }
    public void buyJoker(View view){
        if (poin >=1000) {
            click = MediaPlayer.create(this, R.raw.p5click);
            click.start();
            poin = poin - 1000;
            jkr++;
            ujoker.setText("Use: " + jkr);
            pointt.setText("Point: "+poin);
        }
    }
    public void useJoker(View view){
        int c = ThreadLocalRandom.current().nextInt(1, 5);
        if(jkr>0){
            click = MediaPlayer.create(this, R.raw.p5click);
            click.start();
            if(c == 1){
                mov++;
                umove.setText("Use: " + mov);
            }
            else if (c == 2){
                hlt++;
                uhealt.setText("Use: "+ hlt);
            }
            else if (c == 3){
                jkr++;
                ujoker.setText("Use: "+jkr);
            }
            else if (c == 4){
                poin = poin * 2;
                pointt.setText("Point: "+poin);
            }
            ujoker.setText("Use: " + jkr);
        }
    }
    public void useHealt(View view){
        if(hlt>0){
            click = MediaPlayer.create(this, R.raw.p5click);
            click.start();
            hlt--;
            moveS = moveS + 5;
            if (say.getVisibility() == View.INVISIBLE){
                gameres.setVisibility(View.INVISIBLE);
                say.setVisibility(View.VISIBLE);
            }
            move.setText("Move: "+moveS);
            uhealt.setText("Use: " + hlt);
        }
    }
    public void useMove(View view){
        if(mov>0){
            click = MediaPlayer.create(this, R.raw.p5click);
            click.start();
            mov--;
            moveS++;
            if (say.getVisibility() == View.INVISIBLE){
                gameres.setVisibility(View.INVISIBLE);
                say.setVisibility(View.VISIBLE);
            }
            move.setText("Move: "+moveS);
            umove.setText("Use: " + mov);
        }
    }
    public void restg(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        moveS=5;
        num = ThreadLocalRandom.current().nextInt(1, 11);
        min.setText("1");
        max.setText("10");
        gameres.setVisibility(View.INVISIBLE);
        say.setText("");
        say.setVisibility(View.VISIBLE);
    }
    public void gueq(View view){
        try {
            psay = Integer.parseInt(say.getText().toString());
            if (say.getVisibility() == View.VISIBLE) {

                String mi, mx, c;
                minsay = Integer.parseInt(min.getText().toString());
                maxsay = Integer.parseInt(max.getText().toString());
                if (psay < minsay) {
                    say.setText("");
                    say.setHint("");
                } else if (psay > maxsay) {
                    say.setText("");
                    say.setHint("");
                } else if (psay < num) {
                    if (psay >= num - 3) {
                        click = MediaPlayer.create(this, R.raw.beepbutton);
                        click.start();
                    }
                    if (moveS >= 0) {
                        moveS--;
                    } else {
                        say.setVisibility(View.INVISIBLE);
                    }
                    say.setText("");
                } else if (psay > num) {
                    if (psay <= num + 3) {
                        click = MediaPlayer.create(this, R.raw.beepbutton);
                        click.start();
                    }
                    if (moveS >= 0) {
                        moveS--;
                    } else {
                        say.setVisibility(View.INVISIBLE);
                        gameres.setVisibility(View.VISIBLE);
                    }
                    say.setText("");
                } else if (moveS == 0) {
                    gameres.setVisibility(View.VISIBLE);
                    say.setVisibility(View.INVISIBLE);
                    click = MediaPlayer.create(this, R.raw.gameover);
                    click.start();
                } else {
                    click = MediaPlayer.create(this, R.raw.p5win);
                    click.start();
                    if (moveS == moveSc) {
                        poin = poin + 5 * (moveS * 10);
                        pointt.setText("Point: " + poin);
                    } else {
                        poin = poin + (moveS * 10);
                        pointt.setText("Point: " + poin);

                    }
                    lvl++;
                    if (lvl >= 10) {
                        a = lvl * 5;
                    } else {
                        a = 10 + lvl + 2;
                    }
                    levtx.setText("Level " + lvl);
                    moveS = 5 + (lvl / 3);
                    c = Integer.toString(a);
                    max.setText(c);
                    num = ThreadLocalRandom.current().nextInt(1, a + 1);
                    say.setText("");
                    say.setHint("");
                    if (lvl % 2 == 0) {
                        mov++;
                        umove.setText("Use: " + mov);
                    }
                    if (lvl % 5 == 0) {
                        hlt++;
                        uhealt.setText("Use: " + hlt);
                    }
                    if (lvl % 10 == 0) {
                        jkr++;
                        ujoker.setText("Use: " + jkr);
                    }
                }
                //else if()
            } else {

            }
            move.setText("Move: " + moveS);
            levtx.setText("Level " + lvl);
            pointt.setText("Point: " + poin);
            move.setText("Move: " + moveS);
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
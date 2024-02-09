package com.example.exgam;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class RPSOP extends AppCompatActivity {
    int win=0,lose=0,ch;
    ImageButton rock,paper,scissors,vil;
    TextView cur;
    Button nex,rd;
    boolean paperS=false,rockS=false,scissorsS=false,gg=false;
    int a=0;
    MediaPlayer click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpsop);
        rock = (ImageButton) findViewById(R.id.rkBTN);
        paper = (ImageButton) findViewById(R.id.ppBTN);
        scissors = (ImageButton) findViewById(R.id.scBTN);
        nex = (Button) findViewById(R.id.nxtBTN);
        cur = (TextView) findViewById(R.id.currentTXT);
        vil = (ImageButton) findViewById(R.id.ppIMG);
        rd = (Button) findViewById(R.id.RdBTN);
        cur.setText(lose + " - " + win);
    }
    public void sc(View view){
        if(scissorsS == false) {
            scissors.setImageResource(R.drawable.scissorsk);
            paper.setImageResource(R.drawable.paperg);
            rock.setImageResource(R.drawable.rockg);
            paperS = false;
            rockS = false;
            scissorsS = true;
            gg=true;
            click = MediaPlayer.create(this, R.raw.p5click);
            click.start();
        }
    }
    public void rk(View view){
        if(rockS == false) {
            scissors.setImageResource(R.drawable.scissorsg);
            paper.setImageResource(R.drawable.paperg);
            rock.setImageResource(R.drawable.rockk);
            paperS = false;
            rockS = true;
            scissorsS = false;
            gg=true;
            click = MediaPlayer.create(this, R.raw.p5click);
            click.start();
        }
    }
    public void pp(View view){
            if(paperS == false) {
                scissors.setImageResource(R.drawable.scissorsg);
                paper.setImageResource(R.drawable.paperk);
                rock.setImageResource(R.drawable.rockg);
                paperS = true;
                rockS = false;
                scissorsS = false;
                gg=true;
                click = MediaPlayer.create(this, R.raw.p5click);
                click.start();
            }
    }
    public void rdy(View view){
        a= ThreadLocalRandom.current().nextInt(0, 3);
        if (gg == true){
            if (a == 0 && scissorsS == true){
                vil.setImageResource(R.drawable.rockk);
                lose++;
                click = MediaPlayer.create(this, R.raw.gameover);
                click.start();
                cur.setText(lose + " - " + win);
                click = MediaPlayer.create(this, R.raw.gameover);
                click.start();
            }
            else if (a == 1 && rockS == true ){
                vil.setImageResource(R.drawable.paperk);
                lose++;
                click = MediaPlayer.create(this, R.raw.gameover);
                click.start();
                cur.setText(lose + " - " + win);
                click = MediaPlayer.create(this, R.raw.gameover);
                click.start();
            }
            else if (a == 2 && paperS == true){
                vil.setImageResource(R.drawable.scissorsk);
                lose++;
                click = MediaPlayer.create(this, R.raw.gameover);
                click.start();
                cur.setText(lose + " - " + win);
                click = MediaPlayer.create(this, R.raw.gameover);
                click.start();
            }
            else if (a == 0 && paperS == true){
                vil.setImageResource(R.drawable.rockk);
                win++;
                cur.setText(lose + " - " + win);
                click = MediaPlayer.create(this, R.raw.p5win);
                click.start();
            }
            else if (a == 1 && scissorsS == true ){
                vil.setImageResource(R.drawable.paperk);
                win++;
                cur.setText(lose + " - " + win);
                click = MediaPlayer.create(this, R.raw.p5win);
                click.start();
            }
            else if (a == 2 && scissorsS == true){
                vil.setImageResource(R.drawable.scissorsk);
                cur.setText(lose + " - " + win);
            }
            else if (a == 0 && rockS == true){
                vil.setImageResource(R.drawable.rockk);
            }
            else if (a == 1 && paperS == true ){
                vil.setImageResource(R.drawable.paperk);
            }
            else if (a == 2 && scissorsS == true){
                vil.setImageResource(R.drawable.scissorsk);
            }
            rd.setVisibility(View.INVISIBLE);
            nex.setVisibility(View.VISIBLE);
        }
    }
    public void nn(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        scissors.setImageResource(R.drawable.scissorsg);
        paper.setImageResource(R.drawable.paperg);
        rock.setImageResource(R.drawable.rockg);
        vil.setImageResource(R.drawable.logov2k);
        paperS = false;
        rockS = false;
        scissorsS = false;
        gg=false;
        nex.setVisibility(View.INVISIBLE);
        rd.setVisibility(View.VISIBLE);
    }
}
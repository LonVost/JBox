package com.example.exgam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TPNames extends AppCompatActivity {
Button rdy;
EditText J1,J2;
TextView chek;
String p2="",p1="";
MediaPlayer click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpnames);
        rdy = (Button) findViewById(R.id.GuessBTN);
        J1 = (EditText) findViewById(R.id.NumberTXT);
        J2 = (EditText) findViewById(R.id.J2Name);
        chek = (TextView) findViewById(R.id.checkTXT);
    }
    public void ready(View view){
        click = MediaPlayer.create(this, R.raw.p5click);
        click.start();
        Intent go = new Intent(this, GameSelectTP.class);
        String p1kirac="0",p2kirac="0";
        if(J1.getText().toString().equals("Kira")){
            p1kirac="1";
        }
        else if(J2.getText().toString().equals("Kira")){
            p2kirac="1";
        }
        if(J2.getText().toString().equals("")){
            J2.setText("Joker 2");
        }
        if(J1.getText().toString().equals("")){
            J1.setText("Joker 1");
        }
        if(J1.getText().toString().equals(J2.getText().toString())){
            chek.setVisibility(View.VISIBLE);
        }
        else {
            go.putExtra("joker1", J1.getText().toString());
            go.putExtra("joker2", J2.getText().toString());
            go.putExtra("p1kira", p1kirac);
            go.putExtra("p2kira", p2kirac);
            startActivity(go);
        }

        }

    }
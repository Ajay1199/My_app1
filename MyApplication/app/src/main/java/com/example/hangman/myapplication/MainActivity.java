package com.example.hangman.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void checkforupdates( View v){

        Intent myintent = new Intent(this,Update_Activity.class);

        startActivity(myintent);
    }


    public void startnewgame( View v){

        Intent myIntent = new Intent(this,GameActivity.class);

        startActivity(myIntent);

    }

    public void multigame (View v) {

        Intent myIntent = new Intent(this,Multiplayeractivity.class);

        startActivity(myIntent);
    }

    public void Openscores(View v){

        Intent myintent = new Intent(this,SavescoreActivity.class);

        startActivity(myintent);

    }



    }




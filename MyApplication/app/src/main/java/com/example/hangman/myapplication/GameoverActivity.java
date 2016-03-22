package com.example.hangman.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameoverActivity extends AppCompatActivity {

    int mpoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        int points = getIntent().getIntExtra("POINTS_IDENTIFIER", 0);

        TextView textViewpoints = (TextView) findViewById(R.id.textviewponts);

        textViewpoints.setText(String.valueOf(points));

        mpoints = points;



    }

    public void savescore(View v){

        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

        EditText textView = (EditText) findViewById(R.id.textviewName);

        String name = textView.getText().toString();

        //Name x Points \n Name y Points

        SharedPreferences.Editor  editor = preferences.edit();

        String previousscores = preferences.getString("SCORES","");

        editor.putString("SCORES", name+" "+mpoints+" POINTS \n" + previousscores);

        editor.commit();

        finish();


    }





}


package com.example.hangman.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SavescoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savescore);


        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES",MODE_PRIVATE);

       String scores = preferences.getString("SCORES","NO SCORES");

        TextView textViewscores = (TextView) findViewById(R.id.textViewscores);

        textViewscores.setText(scores);



























    }


}

package com.example.hangman.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Multiplayeractivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayeractivity);
    }

    public void introduceword(View v) {

        EditText myEdittext = (EditText) findViewById(R.id.Edittextword);


        String Word = myEdittext.getText().toString();



        Log.d("my tag", "The Introduce word is" + Word);


        Intent multigameintent = new Intent(this,GameMultiActivity.class);

        multigameintent.putExtra("WORD_IDENTIFIER",Word);

        startActivity(multigameintent);







    }
}

package com.example.hangman.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameMultiActivity extends AppCompatActivity {

    String mword;
    int mfailcounter = 0;
    int mguessedletters = 0;
    int mpoints = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_game);


        String wordsent = getIntent().getStringExtra("WORD_IDENTIFIER");

        Log.d("my tag", "The word sent is" + wordsent);

        mword = wordsent;

        createtextviews(wordsent);



        }

        public void introduceletter(View v){

            EditText myEdittext = (EditText) findViewById(R.id.Edittextletter);

            String Letter = myEdittext.getText().toString();

            myEdittext.setText("");

            Log.i("MYLOG", "the letter is" + Letter);

            if(Letter.length()>0 ) {
                Checkletter(Letter);


            }else
            {
                Toast.makeText(this, "Please insert any letter", Toast.LENGTH_SHORT).show();
            }


        }
        public void Checkletter(String introducedletter) {

            int i;

            char characterintroduce = introducedletter.charAt(0);

            boolean LetterGuessed = false;

            for (i = 0; i < mword.length(); i++) {

                char charfromtheword = mword.charAt(i);

                Log.d("MYTAG", "the letter we are checking is" + charfromtheword);

                if (charfromtheword == characterintroduce) {

                    Log.d("MYTAG", "the letter is match");

                    LetterGuessed = true;
                    showLettersatindex(i, charfromtheword);

                    mguessedletters++;


                }
            }
            if (LetterGuessed == false) {
                LetterFailed(Character.toString(characterintroduce));
            }



            if(mguessedletters == mword.length()){

                multiplayerscreen();


            }


        }

        public void createtextviews(String word) {

            int i;

            LinearLayout layoutletters = (LinearLayout) findViewById(R.id.layoutletters);

            for (i=0; i<word.length(); i++){

                TextView newtextView = (TextView) getLayoutInflater().inflate(R.layout.textview, null);

                layoutletters.addView(newtextView);
            }




        }





        public void clearscreen(){

            int i;

            TextView textviewfailed = (TextView) findViewById(R.id.textView2);

            textviewfailed.setText(" ");

            mguessedletters = 0;
            mfailcounter = 0;

            LinearLayout layoutletters = (LinearLayout) findViewById(R.id.layoutletters);

            for(i=0; i<layoutletters.getChildCount(); i++){

                TextView currenttextview = (TextView) layoutletters.getChildAt(i);

                currenttextview.setText(" ");

            }
            ImageView imageview = (ImageView) findViewById(R.id.imageView3);

            imageview.setImageResource(R.drawable.hangdroid_0);



        }



        public void LetterFailed(String letterfailed) {

            TextView textviewfailed = (TextView) findViewById(R.id.textView2);

            String previousfail = textviewfailed.getText().toString();

            textviewfailed.setText(previousfail + letterfailed);


            mfailcounter++;

            ImageView imageview = (ImageView) findViewById(R.id.imageView3);

            if (mfailcounter == 1) {
                imageview.setImageResource(R.drawable.hangdroid_1);
            } else if(mfailcounter == 2) {
                imageview.setImageResource(R.drawable.hangdroid_2);
            }else if(mfailcounter == 3) {
                imageview.setImageResource(R.drawable.hangdroid_3);
            }else if(mfailcounter == 4) {
                imageview.setImageResource(R.drawable.hangdroid_4);
            }else if(mfailcounter == 5) {
                imageview.setImageResource(R.drawable.hangdroid_5);
            }else if(mfailcounter == 6)
            {
                multiplayerscreen();

            }
        }
        public void multiplayerscreen() {

            Intent multiplayerintent = new Intent(this,Multiplayeractivity.class);

            startActivity(multiplayerintent);

    }



        public void showLettersatindex(int position,char letterguessed){

            LinearLayout layoutletter = (LinearLayout) findViewById(R.id.layoutletters);

            TextView textview = (TextView) layoutletter.getChildAt(position);

            textview.setText(Character.toString(letterguessed));

        }







    }



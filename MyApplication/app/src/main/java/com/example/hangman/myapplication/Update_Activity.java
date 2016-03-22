package com.example.hangman.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.concurrent.ExecutionException;

public class Update_Activity extends AppCompatActivity {

    String latestVersion;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateapp();

    }



    private String getCurrentVersion(){
        PackageManager pm = this.getPackageManager();
        PackageInfo pInfo = null;

        try {
            pInfo =  pm.getPackageInfo(this.getPackageName(),0);

        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }
        String currentVersion = pInfo.versionName;

        return currentVersion;
    }

    private class GetLatestVersion extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                //It retrieves the latest version by scraping the content of current version from play store at runtime
                String urlOfAppFromPlayStore = "https://play.google.com/store/apps/details?id=pl.mee.wisielec&hl=en";
                Document  doc = Jsoup.connect(urlOfAppFromPlayStore).get();
                latestVersion = doc.getElementsByAttributeValue("itemprop","softwareVersion").first().text();

            }catch (Exception e){
                e.printStackTrace();

            }

            return latestVersion;
        }
    }

    public void updateapp(){

    String currentVersion = getCurrentVersion();
    Log.d("MYTAG", "Current version = " + currentVersion);
    try {
        latestVersion = new GetLatestVersion().execute().get();
        Log.d("MYTAG1", "Latest version = " + latestVersion);
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (ExecutionException e) {
        e.printStackTrace();
    }

    //If the versions are not the same
    if(!currentVersion.equals(latestVersion)){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("An Update is Available");
        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Click button action
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=pl.mee.wisielec&hl=en")));
                dialog.dismiss();


            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();



            }
        });

        builder.setCancelable(false);
        builder.show();
    }

    }



}
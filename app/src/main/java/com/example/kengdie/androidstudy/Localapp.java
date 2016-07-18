package com.example.kengdie.androidstudy;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Localapp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localapp);
        Uri uri = getIntent().getData();
        System.out.println(uri);
    }
}

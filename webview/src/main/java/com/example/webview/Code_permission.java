package com.example.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Code_permission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_permission);
        HelloWorld.hello(this);
    }
}

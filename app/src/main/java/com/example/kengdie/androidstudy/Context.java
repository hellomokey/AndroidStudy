package com.example.kengdie.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Context extends AppCompatActivity {

//    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        tv = new TextView(this);
//        tv.setText(R.string.app_name);
////        tv.setText("context");
////        setContentView(R.layout.activity_context);
//
//        setContentView(tv);
        System.out.println(getResources().getText(R.string.app_name));

        ImageView iv = new ImageView(this);
        iv.setImageResource(R.mipmap.ic_launcher);
        setContentView(iv);
    }
}

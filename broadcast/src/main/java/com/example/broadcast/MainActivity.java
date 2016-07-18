package com.example.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttonSendMsg).setOnClickListener(this);
        findViewById(R.id.buttonRegReceiver).setOnClickListener(this);
        findViewById(R.id.buttonUnregReceiver).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonSendMsg:
//                Intent i = new Intent(this,MyReceiver.class);register from manifest.xml
                Intent i = new Intent(MyReceiver.action);//register in this file
                i.putExtra("data","are you ok?");
//                sendBroadcast(i);
                sendOrderedBroadcast(i,null);
                break;
            case R.id.buttonRegReceiver:
                if(myReceiver == null){
                    myReceiver = new MyReceiver();
                    registerReceiver(myReceiver, new IntentFilter(MyReceiver.action));
                }
                break;
            case R.id.buttonUnregReceiver:
                if(myReceiver != null) {
                    unregisterReceiver(myReceiver);
                }
                break;
        }
    }
    private MyReceiver myReceiver = null;
}

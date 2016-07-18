package com.example.app1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class starServicefromanotherApp extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_servicefromanother_app);
        intent = new Intent();
        intent.setComponent(new ComponentName("com.example.kengdie.androidstudy","com.example.kengdie.androidstudy.MyService"));
        findViewById(R.id.buttonStartService).setOnClickListener(this);
        findViewById(R.id.buttonStopService).setOnClickListener(this);
        findViewById(R.id.buttonBindService).setOnClickListener(this);
        findViewById(R.id.buttonUnbindService).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonStartService:
                startService(intent);
                break;
            case R.id.buttonStopService:
                stopService(intent);
                break;
            case R.id.buttonBindService:
                bindService(intent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.buttonUnbindService:
                unbindService(this);
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        System.out.println("service connect");
        System.out.println(iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}

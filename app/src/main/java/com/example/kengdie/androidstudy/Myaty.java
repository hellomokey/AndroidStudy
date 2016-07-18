package com.example.kengdie.androidstudy;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kengdie on 2016/7/17.
 */

public class Myaty extends Activity implements View.OnClickListener, ServiceConnection {

    static final String action = "com.example.kengdie.androidstudy.main.Myaty";
    private  Intent intent;
    private EditText et;
    private MyService.Binder binder = null;
    private TextView tvOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myaty);
        intent = new Intent(Myaty.this,MyService.class);
        et = (EditText) findViewById(R.id.editText2);
        tvOut = (TextView) findViewById(R.id.textView);
        findViewById(R.id.buttonStarService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("data",et.getText().toString());
                startService(intent);
            }
        });
        findViewById(R.id.buttonStopService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });
        findViewById(R.id.buttonbindService).setOnClickListener(this);
        findViewById(R.id.buttonUnbindService).setOnClickListener(this);
        findViewById(R.id.buttonSyncData).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonbindService:
                bindService(intent,this,Context.BIND_AUTO_CREATE);
                break;
            case R.id.buttonUnbindService:
                unbindService(this);
                break;
            case R.id.buttonSyncData:
                if(binder != null){
                    binder.setData(et.getText().toString());
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        binder = (MyService.Binder) iBinder;
        binder.getService().setCallback(new MyService.CallBack() {
            @Override
            public void onDataChange(String data) {//can't disturb thread's inner and outer
                Message msg = new Message();
                Bundle b = new Bundle();
                b.putString("data",data);
                msg.setData(b);
                handler.sendMessage(msg);
            }
        });
        System.out.println("service connected");
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tvOut.setText(msg.getData().getString("data"));
        }
    };
}

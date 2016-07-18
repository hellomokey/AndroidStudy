package com.example.kengdie.androidstudy;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {

    private boolean servicerunnig = false;
    private static String data = "至今思项羽，不肯过江东";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new IMyServiceInterface.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }
        };
    }
    public class Binder extends android.os.Binder{
        void setData(String data){
            MyService.data = data;
        }
        public MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        data = intent.getStringExtra("data");
        System.out.println("service command");

//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                while (servicerunnig) {
//                    System.out.println("service running");
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        servicerunnig = true;
        super.onCreate();
        System.out.println("service create");
        new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;
                while(servicerunnig){
                    String str = i + data;
                    i++;
                    System.out.println(str);
                    if(callback != null){
                        callback.onDataChange(str);
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        servicerunnig = false;
        super.onDestroy();
        System.out.println("service destroys");
    }
    private CallBack callback = null;

    public void setCallback(CallBack callback) {
        this.callback = callback;
    }

    public CallBack getCallback() {
        return callback;
    }

    public static interface CallBack{
        void onDataChange(String data);
    }
}

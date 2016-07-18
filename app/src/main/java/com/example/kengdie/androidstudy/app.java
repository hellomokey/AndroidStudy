package com.example.kengdie.androidstudy;

import android.app.Application;
import android.content.res.Configuration;

/**
 * Created by kengdie on 2016/7/18.
 */

public class app extends Application {
    private String str = "application";
    public String getStr(){
        return str;
    }
    void setStr(String str){
        this.str = str;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}

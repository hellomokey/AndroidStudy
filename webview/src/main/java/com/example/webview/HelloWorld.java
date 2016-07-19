package com.example.webview;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by kengdie on 2016/7/19.
 */

public class HelloWorld {
    private static final String PERMISSON = "com.example.webview.permission.HelloWorld";
    public static void hello(Context context){
        if(context.checkCallingOrSelfPermission(PERMISSON) != PackageManager.PERMISSION_GRANTED) {
            throw new SecurityException("com.example.webview.permission.HelloWorld requires permisssion");
        }
        System.out.println("hello code");
    }
}

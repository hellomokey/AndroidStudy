package com.example.kengdie.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kengdie on 2016/7/18.
 */

public class Main2 extends Activity {
    private TextView tv;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView2);
        et = (EditText) findViewById(R.id.editText);
        tv.setText("share data:" + ((app)getApplicationContext()).getStr());

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((app)getApplicationContext()).setStr(et.getText().toString());
                tv.setText("share data:"+et.getText().toString());
//                startActivity(new Intent(Myaty.action));
            }
        });
    }
}

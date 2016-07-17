package com.example.app1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent("com.example.kengdie.androidstudy.main.Myaty", Uri.parse("app://hello")));
                }catch (Exception e) {
                    Toast.makeText(MainActivity.this,"can't launcher actibity \"myaty\"",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

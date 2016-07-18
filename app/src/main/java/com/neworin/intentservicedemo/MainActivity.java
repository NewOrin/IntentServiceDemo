package com.neworin.intentservicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        /**
         * 启动服务
         */
        Intent intent = new Intent(MainActivity.this, MyIntentService.class);
        startService(intent);
        Log.d(TAG, "当前线程id:" + Thread.currentThread().getId());
    }
}

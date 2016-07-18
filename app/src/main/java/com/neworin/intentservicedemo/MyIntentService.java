package com.neworin.intentservicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by NewOrin Zhang on 2016/7/18.
 * E-Mail : NewOrinZhang@Gmail.com
 */
public class MyIntentService extends IntentService {

    private String TAG = "MyIntentService";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyIntentService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "这是onHandleIntent方法");
        /**
         * 让程序睡眠10秒钟
         */
        long endTime = System.currentTimeMillis() + 10 * 1000;
        while (System.currentTimeMillis() < endTime) {
            synchronized (this) {
                try {
                    Log.d(TAG, "当前线程id:" + Thread.currentThread().getId());
                    wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "启动了IntentService服务");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "IntentService服务已销毁");
    }
}

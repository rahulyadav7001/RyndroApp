package com.ryandro.ryndroapp.service_demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ryandro.ryndroapp.R;

/**
 * Created by WIN 1O on 14-03-2018.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(getResources().getString(R.string.Service_Demo_Tag), "In OnStartCommond, Thread ID: " + Thread.currentThread().getId() + "");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(getResources().getString(R.string.Service_Demo_Tag), "In OnDestroy, Thread ID: " + Thread.currentThread().getId() + "");

    }
}

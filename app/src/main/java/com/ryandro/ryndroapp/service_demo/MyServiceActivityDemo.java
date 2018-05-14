package com.ryandro.ryndroapp.service_demo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ryandro.ryndroapp.BaseActivity;
import com.ryandro.ryndroapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyServiceActivityDemo extends BaseActivity implements View.OnClickListener {
    @Nullable
    @BindView(R.id.btn_stopService)
    Button btn_stopService;
   /* @Nullable
    @Bind(R.id.btn_startService)
     Button btn_startService;*/

    private Intent serviceIntent;

    @Override
    public void initialize() {
        inflater.inflate(R.layout.activity_my_service_demo, flBody, true);
        ButterKnife.bind(this);
        serviceIntent = new Intent(getApplicationContext(), MyService.class);
        Log.d(getResources().getString(R.string.Service_Demo_Tag), "In Service Activity, Thread ID: " + Thread.currentThread().getId() + "");

    }

    /*   @OnClick(R.id.btn_startService)
      public void submitButton(View view){
           switch (view.getId()) {
               case R.id.btn_startService:
                   startService(serviceIntent);
                   break;
               case R.id.btn_stopService:
                   break;
           }

       }*/
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_startService:
                startService(serviceIntent);
                break;
            case R.id.btn_stopService:
                break;
        }
    }
}

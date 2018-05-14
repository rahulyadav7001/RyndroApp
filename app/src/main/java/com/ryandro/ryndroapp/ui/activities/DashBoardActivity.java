package com.ryandro.ryndroapp.ui.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ryandro.ryndroapp.BaseActivity;
import com.ryandro.ryndroapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashBoardActivity extends BaseActivity {
    @Nullable
    @BindView(R.id.btn_fb)
    Button btn_fb;
    @Nullable
    @BindView(R.id.tv_customView)
    TextView tv_customView;
    @Nullable
    @BindView(R.id.textView4)
    TextView textView4;
    @Nullable
    @BindView(R.id.btn_Service)
    TextView btn_Service;
    @Nullable
    @BindView(R.id.btn_ContentProvider)
    TextView btn_ContentProvider;
    int counter = 0, i = 1;
    private Intent intent;

    private Handler handler;

    @Override
    public void initialize() {
        inflater.inflate(R.layout.activity_dash_board, flBody, true);
        ButterKnife.bind(this);

//        tv_customView.setTextColor(getResources().getColor(R.color.colorPrimary));


       /* btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoardActivity.this, FacebookImplementActivity.class));

            }
        });*/
//       handler = new Handler();

       /* btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(25000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        tv_customView.setText(String.valueOf(counter));
                        if (i == 1) {
                            tv_customView.setTextColor(Color.RED);
                            i = 2;
                        } else if (i == 2) {
                            tv_customView.setTextColor(Color.GREEN);
                            i = 3;
                        } else if (i == 3) {
                            tv_customView.setTextColor(getResources().getColor(R.color.colorPrimary));
                            i = 1;
                        }
                        counter++;
                    }

                    public void onFinish() {
                        tv_customView.setText("FINISH!!");
                        counter = 0;
                        i = 1;
                    }
                }.start();
            }
        });*/

       /* btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(runnable,10);
            }
        });*/
//         btn_fb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tv_customView.setText("Color Changing Text");
//            }
//        });

       /*  btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoardActivity.this, MyServiceActivityDemo.class));

            }
        });*/
        btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoardActivity.this, ButterKnifeActivity.class));

            }
        });
    }

    /* public Runnable runnable = new Runnable() {
         @Override
         public void run() {

             tv_customView.setText(""+SystemClock.uptimeMillis());


         }
     };*/


    /*@OnClick({R.id.btn_Service, R.id.btn_ContentProvider, R.id.btn_fb})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Service:
                Log.d("Click Event", "Service Button");
//                startActivity(new Intent(getApplicationContext(), MyServiceActivityDemo.class));
                break;
            case R.id.btn_ContentProvider:
                Log.d("Click Event", "Content Provider Button");

//                startActivity(new Intent(DashBoardActivity.this, ContentProviderActivity.class));
                break;
            case R.id.btn_fb:
                Log.d("Click Event", "Service Facebook Connect");

//                startActivity(new Intent(getApplicationContext(), MyServiceActivityDemo.class));
                break;
        }
    }*/
}

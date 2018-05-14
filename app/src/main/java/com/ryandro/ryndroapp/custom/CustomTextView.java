package com.ryandro.ryndroapp.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ryandro.ryndroapp.R;

/**
 * Created by WIN 1O on 16-02-2018.
 */

@SuppressLint("AppCompatCustomView")
public class CustomTextView extends TextView {
    int i=0;
    TextView tv_tmp = this;
    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        this.setTextColor(Color.CYAN);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
//        this.setTextColor(Color.BLACK);
    }

    public CustomTextView(Context context) {
        super(context);
//        this.setTextColor(Color.RED);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        this.setTextColor(Color.GREEN);
    }

    @Override
    public void setTextColor(ColorStateList colors) {
        super.setTextColor(colors);
//        this.setTextColor(Color.RED);
    }

    int counter = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.setTextColor(Color.RED);

      /*  new CountDownTimer(2500, 2000) {
            public void onTick(long millisUntilFinished) {
//                tv_tmp.setText(String.valueOf(counter));
                if (i == 1) {
                    tv_tmp.setTextColor(Color.RED);
                    i = 2;
                } else if (i == 2) {
                    tv_tmp.setTextColor(Color.GREEN);
                    i = 3;
                } else if (i == 3) {
                    tv_tmp.setTextColor(getResources().getColor(R.color.colorPrimary));
                    i = 1;
                }
                counter++;
            }

            public void onFinish() {
//                tv_tmp.setText("FINISH!!");
                counter = 0;
                i = 1;
            }
        }.start();*/
       /* int colorValue = 1;
        while(true){
            if (colorValue == 1) {
                this.setTextColor(Color.RED);
                colorValue = 2;
            } else if (colorValue == 2) {
                this.setTextColor(Color.GREEN);
                colorValue = 3;
            } else if (colorValue == 3) {
                this.setTextColor(Color.BLUE);
                colorValue = 1;
            }
        }*/
    }

    /*public void setTextChangedColor(int color){
        super.setTextColor(color);
        this.setTextColor(color);
    }*/

}

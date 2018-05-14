package com.ryandro.ryndroapp.ui.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ryandro.ryndroapp.R;

import butterknife.ButterKnife;

public class ButterKnifeActivity extends AppCompatActivity {
    ButterKnifeActivity butterKnifeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        ButterKnife.bind(this);



    }
}

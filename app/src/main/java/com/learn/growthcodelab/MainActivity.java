package com.learn.growthcodelab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.learn.growthcodelab.activity.DataBindingActivity;
import com.learn.growthcodelab.activity.DrawableActivity;
import com.learn.growthcodelab.activity.FitSystemWindowActivity;
import com.learn.growthcodelab.activity.MeasurementActivity;
import com.learn.growthcodelab.activity.WebViewActivity;
import com.learn.growthcodelab.activity.RecyclerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_main_data_binding).setOnClickListener(this);
        findViewById(R.id.btn_main_fit_system_window).setOnClickListener(this);
        findViewById(R.id.btn_main_web_view).setOnClickListener(this);
        findViewById(R.id.btn_main_recycler).setOnClickListener(this);
        findViewById(R.id.btn_main_measurement).setOnClickListener(this);
        findViewById(R.id.btn_main_drawable).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_main_data_binding:
                DataBindingActivity.start(this);
                break;
            case R.id.btn_main_fit_system_window:
                FitSystemWindowActivity.start(this);
                break;
            case R.id.btn_main_web_view:
                WebViewActivity.start(this);
                break;
            case R.id.btn_main_recycler:
                RecyclerActivity.start(this);
                break;
            case R.id.btn_main_measurement:
                MeasurementActivity.start(this);
                break;
            case R.id.btn_main_drawable:
                DrawableActivity.start(this);
                break;
        }
    }
}

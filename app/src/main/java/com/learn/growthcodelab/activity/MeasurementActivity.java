package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.learn.growthcodelab.R;

public class MeasurementActivity extends BaseActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context, MeasurementActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement);
    }
}

package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {

    public static void start(Context context, Class<? extends BaseActivity> activityClazz){
        context.startActivity(new Intent(context, DataBindingActivity.class));
    }

}

package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {

    public static void start(Context context, Class<? extends BaseActivity> activityClazz){
        context.startActivity(new Intent(context, DataBindingActivity.class));
    }

}

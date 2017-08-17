package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.databinding.ActivityDataBindingBinding;
import com.learn.growthcodelab.databinding.model.User;


public class DataBindingActivity extends BaseActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context, DataBindingActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingBinding activityDataBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        User user = new User("Jack", "Smith");
        activityDataBindingBinding.setUser(user);
    }
}

package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;

public class NestedScrollActivity extends BaseActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context, NestedScrollActivity.class));
    }


}

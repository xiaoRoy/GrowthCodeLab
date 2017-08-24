package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.learn.growthcodelab.R;

public class FitSystemWindowActivity extends BaseActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context, FitSystemWindowActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_system_window);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            /*getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            int systemUiVisibility =  getWindow().getDecorView().getSystemUiVisibility();
            Log.e("trail", "FitSystemWindowActivity.onCreate.systemUiVisibility:" + systemUiVisibility);
            boolean isFullScreen = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN & systemUiVisibility) == View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            boolean isLayoutStable = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE & systemUiVisibility) == View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            Log.e("trail", "FitSystemWindowActivity.onCreate.isFullScreen:" + isFullScreen);
            Log.e("trail", "FitSystemWindowActivity.onCreate.isLayoutStable:" + isLayoutStable);
            boolean isHideNavigation = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION & systemUiVisibility) == View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            Log.e("trail", "FitSystemWindowActivity.onCreate.isHideNavigation:" + isHideNavigation);*/
        }
    }


}

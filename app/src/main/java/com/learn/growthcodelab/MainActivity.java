package com.learn.growthcodelab;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.learn.growthcodelab.activity.DataBindingActivity;
import com.learn.growthcodelab.activity.DrawableActivity;
import com.learn.growthcodelab.activity.FitSystemWindowActivity;
import com.learn.growthcodelab.activity.LayoutActivity;
import com.learn.growthcodelab.activity.MeasurementActivity;
import com.learn.growthcodelab.activity.PlayGroundActivity;
import com.learn.growthcodelab.activity.TransitionActivity;
import com.learn.growthcodelab.activity.ViewPagerActivity;
import com.learn.growthcodelab.activity.WebViewActivity;
import com.learn.growthcodelab.activity.RecyclerActivity;
import com.learn.growthcodelab.databinding.ActivityMainBinding;
import com.learn.growthcodelab.fullscreen.FullScreenActivity;
import com.learn.growthcodelab.handler.HandlerActivity;
import com.learn.growthcodelab.handler.HandlerActivityJ;
import com.learn.growthcodelab.search.SearchActivity;
import com.learn.growthcodelab.touchagain.TouchAgainActivity;
import com.learn.growthcodelab.viewshowcase.ViewShowcaseActivity;
import com.learn.growthcodelab.window.WindowActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setOnClickListener(this);
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
            case R.id.btn_main_play_ground:
                PlayGroundActivity.start(this);
                break;
            case R.id.btn_main_layout:
                LayoutActivity.start(this);
                break;
            case R.id.btn_main_view_pager:
                ViewPagerActivity.start(this);
                break;
            case R.id.btn_main_tab_host:
                break;
            case R.id.btn_main_scene:
                TransitionActivity.start(this);
                break;
            case R.id.btn_main_full_screen:
                FullScreenActivity.start(this);
            case R.id.btn_main_handler:
                HandlerActivity.Companion.start(this);
                break;
            case R.id.btn_main_touch_again:
                TouchAgainActivity.Companion.start(this);
                break;
            case R.id.btn_main_search:
                SearchActivity.Companion.start(this);
            case R.id.btn_main_window:
                WindowActivity.Companion.start(this);
                break;
            case R.id.btn_view_showcase:
                ViewShowcaseActivity.Companion.start(this);
                break;
        }
    }
}

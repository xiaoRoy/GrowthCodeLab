package com.learn.growthcodelab;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.FrameMetrics;
import android.view.View;
import android.view.Window;

import com.learn.growthcodelab.activity.DataBindingActivity;
import com.learn.growthcodelab.activity.DrawableActivity;
import com.learn.growthcodelab.activity.LayoutActivity;
import com.learn.growthcodelab.activity.MeasurementActivity;
import com.learn.growthcodelab.activity.PlayGroundActivity;
import com.learn.growthcodelab.activity.TransitionActivity;
import com.learn.growthcodelab.activity.ViewPagerActivity;
import com.learn.growthcodelab.activity.WebViewActivity;
import com.learn.growthcodelab.activity.RecyclerActivity;
import com.learn.growthcodelab.architecture.jetpack.courtcounter.CourtCounterActivity;
import com.learn.growthcodelab.architecture.jetpack.word.ui.WordsActivity;
import com.learn.growthcodelab.databinding.ActivityMainBinding;
import com.learn.growthcodelab.fragment.FragmentPlayGroundActivity;
import com.learn.growthcodelab.fullscreen.FullScreenActivity;
import com.learn.growthcodelab.handler.HandlerActivity;
import com.learn.growthcodelab.search.SearchActivity;
import com.learn.growthcodelab.touchagain.TouchAgainActivity;
import com.learn.growthcodelab.viewshowcase.ViewShowcaseActivity;
import com.learn.growthcodelab.window.drawer.DrawerActivity;
import com.learn.growthcodelab.window.WindowActivity;
import com.learn.growthcodelab.window.WindowInsetActivity;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Handler frameMetricsHandler = new Handler();

    @RequiresApi(Build.VERSION_CODES.N)
    private  Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener = new Window.OnFrameMetricsAvailableListener() {
        @Override
        public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int dropCountSinceLastInvocation) {
            FrameMetrics frameMetricsCopy = new FrameMetrics(frameMetrics);
            long measureDuration = frameMetricsCopy.getMetric(FrameMetrics.LAYOUT_MEASURE_DURATION);
            long totalDuration = frameMetricsCopy.getMetric(FrameMetrics.TOTAL_DURATION);
            Log.d("Metrics", "LAYOUT_MEASURE_DURATION:" + TimeUnit.NANOSECONDS.toMillis(measureDuration));
            Log.d("Metrics", "TOTAL_DURATION:" + TimeUnit.NANOSECONDS.toMillis(totalDuration));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        addOnFrameMetricsAvailableListener();
    }

    private void addOnFrameMetricsAvailableListener() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            getWindow().addOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener, frameMetricsHandler);
        }
    }

    @Override
    protected void onPause() {
//        removeOnFrameMetricsAvailableListener();
        super.onPause();
    }

     private void removeOnFrameMetricsAvailableListener() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            getWindow().removeOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_main_data_binding:
                DataBindingActivity.start(this);
                break;
            case R.id.btn_main_fit_system_window:
                WindowInsetActivity.Companion.start(this);
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
                break;
            case R.id.btn_main_window:
                WindowActivity.Companion.start(this);
                break;
            case R.id.btn_view_showcase:
                ViewShowcaseActivity.Companion.start(this);
                break;
            case R.id.btn_main_words:
                WordsActivity.Companion.start(this);
                break;
            case R.id.btn_fragment_play_ground:
                FragmentPlayGroundActivity.Companion.start(this);
                break;
            case R.id.btn_drawer:
                DrawerActivity.Companion.start(this);
                break;
            case R.id.btn_main_court_counter:
                CourtCounterActivity.Companion.start(this);
                break;
        }
    }
}

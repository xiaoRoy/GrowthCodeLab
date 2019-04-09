package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.FrameMetrics;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.playground.OverdrawFragment;
import com.learn.growthcodelab.viewshowcase.constraint.AddViewToConstraintFragment;

import java.util.concurrent.TimeUnit;


public class PlayGroundActivity extends AppCompatActivity {

     private Handler frameMetricsHandler = new Handler();

    private long all = 0;
    private int overSixteen = 0;
    private int totalFrames = 0;

    @RequiresApi(Build.VERSION_CODES.N)
    private  Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener = new Window.OnFrameMetricsAvailableListener() {
        @Override
        public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int dropCountSinceLastInvocation) {
            FrameMetrics frameMetricsCopy = new FrameMetrics(frameMetrics);
            long measureDuration = frameMetricsCopy.getMetric(FrameMetrics.LAYOUT_MEASURE_DURATION);
            long totalDuration = frameMetricsCopy.getMetric(FrameMetrics.TOTAL_DURATION);
            Log.d("Metrics", "LAYOUT_MEASURE_DURATION:" + TimeUnit.NANOSECONDS.toMillis(measureDuration));
            Log.d("Metrics", "TOTAL_DURATION:" + TimeUnit.NANOSECONDS.toMillis(totalDuration));
            all += totalDuration;
            totalFrames++;
            Log.d("Metrics", "LAYOUT_MEASURE_DURATION:" + TimeUnit.NANOSECONDS.toMillis(measureDuration));
            Log.d("Metrics", "TOTAL_DURATION:" + TimeUnit.NANOSECONDS.toMillis(totalDuration));
            if (TimeUnit.NANOSECONDS.toMillis(totalDuration) > 16) {
                overSixteen++;
            }
            Log.d("Metrics", "All:" + TimeUnit.NANOSECONDS.toMillis(all));
            Log.d("Metrics", "totalFrames:" + totalFrames);
            Log.d("Metrics", "overSixteen:" + overSixteen);
        }
    };

    public static void start(Context context) {
        context.startActivity(new Intent(context, PlayGroundActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        addOnFrameMetricsAvailableListener();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_play_ground_container,
                        OverdrawFragment.Companion.newInstance(),
                        "add view to constraint")
                .addToBackStack(null)
                .commit();
    }

      @Override
    protected void onResume() {
        super.onResume();
        addOnFrameMetricsAvailableListener();
    }

    private void addOnFrameMetricsAvailableListener() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            getWindow().addOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener, frameMetricsHandler);
        }
    }

    @Override
    protected void onPause() {
        removeOnFrameMetricsAvailableListener();
        super.onPause();
    }

     private void removeOnFrameMetricsAvailableListener() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            getWindow().removeOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener);
        }
    }
}

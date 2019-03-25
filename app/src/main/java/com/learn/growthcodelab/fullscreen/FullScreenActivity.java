package com.learn.growthcodelab.fullscreen;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.view.ViewGroup;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.activity.BaseActivity;
import com.learn.growthcodelab.databinding.ActivityFullScreenBinding;

public class FullScreenActivity extends BaseActivity implements FullScreenNavigator {

    private ActivityFullScreenBinding mActivityFullScreenBinding;

    public static void start(Context context){
        context.startActivity(new Intent(context, FullScreenActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityFullScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_full_screen);
        final View viewContainer = mActivityFullScreenBinding.flFullScreenContainer;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            viewContainer.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if(ViewCompat.getFitsSystemWindows(mActivityFullScreenBinding.flFullScreenContainer)){
            ViewCompat.setOnApplyWindowInsetsListener(viewContainer, new OnApplyWindowInsetsListener() {
                @Override
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat insets) {
                    if(view instanceof ViewGroup){
                        ViewGroup container = (ViewGroup)view;
                        final int childCount = container.getChildCount();
                        for(int index = 0; index < childCount; index ++){
                            final View viewChild = container.getChildAt(index);
                            if(ViewCompat.getFitsSystemWindows(viewChild)){
                                ViewCompat.dispatchApplyWindowInsets(viewChild, insets);
                                break;
                            }
                        }
                    }
                    // no matter what, we will KEEP this inset, either handled by the container or handled by the child.
                    return insets.consumeSystemWindowInsets();
                }
            });
        }
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_full_screen_container, FullScreenFragment.newInstance(), "Full Screen")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void navigateToHasStatusBar() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_full_screen_container, StatusBarFragment.newInstance(), "Status Bar")
                .addToBackStack(null)
                .commit();
    }
}

package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.learn.growthcodelab.R;

public class LayoutActivity extends BaseActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context, LayoutActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        RelativeLayout rlContainer = (RelativeLayout)findViewById(R.id.rl_layout_container);
        View viewFooter = LayoutInflater.from(this).inflate(R.layout.layout_footer, rlContainer, false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFooter.getLayoutParams();
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        System.out.println("trail.index:"+ rlContainer.indexOfChild(viewFooter));
    }
}

package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.learn.growthcodelab.R;

public class DrawableActivity extends BaseActivity implements View.OnClickListener{

    private ImageView mIvFood;

    public static void start(Context context){
        context.startActivity(new Intent(context, DrawableActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        findViewById(R.id.btn_drawable_clip).setOnClickListener(this);
        mIvFood = (ImageView) findViewById(R.id.iv_food);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_drawable_clip:
                ClipDrawable clipDrawable = (ClipDrawable) mIvFood.getBackground();
                clipDrawable.setLevel(clipDrawable.getLevel() + 1000);
                break;
        }
    }
}

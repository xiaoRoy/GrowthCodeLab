package com.learn.growthcodelab.view;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.learn.growthcodelab.R;


public class FixedRatioView extends View {
    public FixedRatioView(Context context) {
        super(context);
    }

    public FixedRatioView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FixedRatioView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = resolveSize(widthMeasureSpec);
        int height = resolveSize(heightMeasureSpec);
        if(width > height){
            height = ((int) (width / 2.0f + 0.5f));
        } else if(height > width) {
            width = ((int) (height / 2.0f + 0.5f));
        }
        setMeasuredDimension(resolveSizeAndState(width, widthMeasureSpec, 0),
                                resolveSizeAndState(height, heightMeasureSpec, 0));
    }

    private int resolveSize(int measureSpec){
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        int resultSize;
        switch (mode){
            case MeasureSpec.AT_MOST:
                resultSize = getResources().getDimensionPixelSize(R.dimen.d_fixed_ratio_default_size);
                break;
            case MeasureSpec.EXACTLY:
            case MeasureSpec.UNSPECIFIED:
            default:
                resultSize = size;
                break;
        }
        return resultSize;
    }
}

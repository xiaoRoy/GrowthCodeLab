package com.learn.growthcodelab.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class NestedScrollingChildView extends View {

    public NestedScrollingChildView(Context context) {
        this(context, null);
    }

    public NestedScrollingChildView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestedScrollingChildView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){

    }
}

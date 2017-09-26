package com.learn.growthcodelab.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

import com.learn.growthcodelab.R;


public class WhatInsetFrameLayout extends FrameLayout {

     private Drawable mInsetForeground;

    private Rect mInsets;

    private Rect mTempRect = new Rect();

    public WhatInsetFrameLayout(Context context) {
        this(context, null);
    }

    public WhatInsetFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WhatInsetFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.WhatInsetFrameLayout, defStyleAttr, 0);
        mInsetForeground = a.getDrawable(R.styleable.WhatInsetFrameLayout_whatInsetForeground);
        a.recycle();
        setWillNotDraw(true); // No need to draw until the insets are adjusted

        ViewCompat.setOnApplyWindowInsetsListener(this,
                new android.support.v4.view.OnApplyWindowInsetsListener() {
                    @Override
                    public WindowInsetsCompat onApplyWindowInsets(View v,
                                                                  WindowInsetsCompat insets) {
                        if (null == mInsets) {
                            mInsets = new Rect();
                        }
                        mInsets.set(insets.getSystemWindowInsetLeft(),
                                insets.getSystemWindowInsetTop(),
                                insets.getSystemWindowInsetRight(),
                                insets.getSystemWindowInsetBottom());
                        onInsetsChanged(mInsets);
                        setWillNotDraw(mInsets.isEmpty() || mInsetForeground == null);
                        ViewCompat.postInvalidateOnAnimation(WhatInsetFrameLayout.this);
                        return insets.consumeSystemWindowInsets();
                    }
                });
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null == mInsets) {
                mInsets = new Rect();
            }
            mInsets.left = insets.getSystemWindowInsetLeft();
            mInsets.top = insets.getSystemWindowInsetTop();
            mInsets.right = insets.getSystemWindowInsetRight();
            mInsets.bottom = insets.getSystemWindowInsetBottom();
//            int top = getResources().getDimensionPixelSize(R.dimen.d_status_bar_height);
//            return super.onApplyWindowInsets(insets.replaceSystemWindowInsets(0, top * 2, 0, 0));
            return insets.consumeSystemWindowInsets();
        } else {
            return insets;
        }
    }


    @Override
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);

        int width = getWidth();
        int height = getHeight();
        if (mInsets != null && mInsetForeground != null) {
            int sc = canvas.save();
            canvas.translate(getScrollX(), getScrollY());

            // Top
            mTempRect.set(0, 0, width, mInsets.top);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);

            // Bottom
            mTempRect.set(0, height - mInsets.bottom, width, height);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);

            // Left
            mTempRect.set(0, mInsets.top, mInsets.left, height - mInsets.bottom);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);

            // Right
            mTempRect.set(width - mInsets.right, mInsets.top, width, height - mInsets.bottom);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);

            canvas.restoreToCount(sc);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mInsetForeground != null) {
            mInsetForeground.setCallback(this);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mInsetForeground != null) {
            mInsetForeground.setCallback(null);
        }
    }

    protected void onInsetsChanged(Rect insets) {
    }
}

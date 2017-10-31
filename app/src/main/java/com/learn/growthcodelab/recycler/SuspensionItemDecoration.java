package com.learn.growthcodelab.recycler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.learn.growthcodelab.R;


public class SuspensionItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint = new Paint();

    private TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

    private Rect mSuspensionRect;

    public SuspensionItemDecoration() {
        mPaint.setAntiAlias(true);
        mSuspensionRect = new Rect();
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        Log.i("trail", "onDraw");
        final Resources resource = parent.getResources();
        final int height = resource.getDimensionPixelSize(R.dimen.d_suspension_height);
        super.onDraw(canvas, parent, state);
        int count = parent.getChildCount();
        for (int index = 0; index < count; index++) {
            View child = parent.getChildAt(index);
            int position = parent.getChildAdapterPosition(child);
            if (position == 4 || position == 10 || index == 0) {
                int left = 0;
                int top = child.getTop() - height;
                int right = child.getRight();
                int bottom = child.getTop();
                mSuspensionRect.set(left, top, right, bottom);
                mPaint.setColor(ContextCompat.getColor(parent.getContext(), android.R.color.holo_blue_dark));
//                mTextPaint.setColor(ContextCompat.getColor(parent.getContext(), android.R.color.holo_red_dark));
                canvas.drawRect(mSuspensionRect, mPaint);
//                canvas.drawText("Abc", child.getLeft(), child.getTop(), mTextPaint);
            }
        }
    }

    private static int getChildAdapterPosition(View child) {
        RecyclerView.LayoutParams layoutParams = ((RecyclerView.LayoutParams) child.getLayoutParams());
        return layoutParams.getViewAdapterPosition();
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Log.i("trail", "getItemOffsets");
        int index = parent.getChildAdapterPosition(view);

        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;
        if (index == 4 || index == 10 || index == 0) {
            final Resources resource = parent.getResources();
            top = resource.getDimensionPixelSize(R.dimen.d_suspension_height);
        }
        outRect.top = top;
    }

    /*@Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        Log.i("trail", "onDrawOver");
        super.onDrawOver(canvas, parent, state);
        final LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        int childCount = parent.getChildCount();
        for (int index = 0; index < childCount; index++) {
            View child = parent.getChildAt(index);
            if(firstVisiblePosition == getChildAdapterPosition(child)){
                int left = 0;
                int top = 0;
                int right = child.getRight();
                int bottom = parent.getResources().getDimensionPixelSize(R.dimen.d_suspension_height);
                mPaint.setColor(ContextCompat.getColor(parent.getContext(), android.R.color.holo_red_dark));
                mSuspensionRect.set(left, top, right, bottom);
                canvas.drawRect(mSuspensionRect, mPaint);
//                canvas.drawText("Abc", child.getLeft(), child.getTop(), mTextPaint);
            }
        }
    }*/

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        final LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        Log.i("trail", "onDrawOver.firstVisiblePosition:"  + firstVisiblePosition);
        int height = parent.getResources().getDimensionPixelSize(R.dimen.d_suspension_height);
        int left = 0;
        int top = 0;
        int right = parent.getRight();
        int bottom = height;
        if(firstVisiblePosition == -1 || firstVisiblePosition == 3 || firstVisiblePosition == 9){
            //getFirstVisibleView
            View viewFirstVisible = null;
            int childCount = parent.getChildCount();
            for (int index = 0; index < childCount; index++) {
                View child = parent.getChildAt(index);
                int position = getChildAdapterPosition(child);
                if(position == firstVisiblePosition){
                    viewFirstVisible = child;
                    break;
                }
            }
            if(viewFirstVisible != null && viewFirstVisible.getBottom() <= height){
                bottom = viewFirstVisible.getBottom();
                Log.i("trail", "onDrawOver.bottom:"  + bottom);
            }
        }
        mPaint.setColor(ContextCompat.getColor(parent.getContext(), android.R.color.holo_red_dark));
        mSuspensionRect.set(left, top, right, bottom);
        canvas.drawRect(mSuspensionRect, mPaint);
    }

    private void drawTitle() {

    }
}

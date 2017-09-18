package com.learn.growthcodelab.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;


public class TextLayoutManager extends RecyclerView.LayoutManager {
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void detachAndScrapView(View child, RecyclerView.Recycler recycler) {
        super.detachAndScrapView(child, recycler);
    }

    @Override
    public void removeAndRecycleView(View child, RecyclerView.Recycler recycler) {
        super.removeAndRecycleView(child, recycler);
    }

}

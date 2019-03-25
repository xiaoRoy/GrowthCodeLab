package com.learn.growthcodelab.view.viewpager;

import android.os.Parcelable;
import androidx.viewpager.widget.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;


public class InfiniteViewPagerAdapter extends PagerAdapter {

    final private PagerAdapter mPagerAdapter;

    private boolean mHasCaching;

    private SparseArray<Boundary> mBoundarySparseArray = new SparseArray<>();

    public InfiniteViewPagerAdapter(PagerAdapter pagerAdapter) {
        mPagerAdapter = pagerAdapter;
    }

    public PagerAdapter getPagerAdapter() {
        return mPagerAdapter;
    }

    public void setHasCaching(boolean hasCaching) {
        mHasCaching = hasCaching;
    }

    @Override
    public int getCount() {
        return mPagerAdapter.getCount() + 2;
    }

    public int getExactCount(){
        return mPagerAdapter.getCount();
    }

    int calculateExactPosition(int adapterPosition){
        int exactCount = getExactCount();
        int exactPosition = 0;
        if(exactCount > 0){
            exactPosition = (adapterPosition - 1) % exactCount;
        }
        if(exactPosition < 0){
            exactPosition += exactCount;
        }
        return exactPosition;
    }

    public int calculateAdapterPosition(int exactPosition){
        return exactPosition + 1;
    }

    private int getExactFirstAdapterPosition(){
        return 1;
    }

    private int getExactLastAdapterPosition(){
        return getExactCount();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object item;
        Boundary boundary = mBoundarySparseArray.get(position);
        if(mHasCaching && boundary != null){
            mBoundarySparseArray.remove(position);
            item = boundary.object;
        } else {
            int exactionPosition =  calculateExactPosition(position);
            item = mPagerAdapter.instantiateItem(container, exactionPosition);
        }
        return item;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int exactFirstAdapterPosition = getExactFirstAdapterPosition();
        int exactLastAdapterPosition = getExactLastAdapterPosition();
        int exactPosition = calculateExactPosition(position);
        if(mHasCaching && (exactFirstAdapterPosition == exactPosition || exactLastAdapterPosition == exactPosition)){
            mBoundarySparseArray.put(position, new Boundary(container, exactPosition, object));
        } else {
            mPagerAdapter.destroyItem(container, position, object);
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return mPagerAdapter.isViewFromObject(view, object);
    }

    @Override
    public void startUpdate(ViewGroup container) {
        mPagerAdapter.startUpdate(container);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        mPagerAdapter.finishUpdate(container);
    }

    @Override
    public Parcelable saveState() {
        return mPagerAdapter.saveState();
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        mPagerAdapter.restoreState(state, loader);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mPagerAdapter.setPrimaryItem(container, position, object);
    }

    @Override
    public void notifyDataSetChanged() {
        mBoundarySparseArray.clear();
        super.notifyDataSetChanged();
    }

    static class Boundary {
        ViewGroup container;
        int position;
        Object object;

        public Boundary(ViewGroup container, int position, Object object) {
            this.container = container;
            this.position = position;
            this.object = object;
        }
    }
}

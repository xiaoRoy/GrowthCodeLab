package com.learn.growthcodelab.view.viewpager;

import android.content.Context;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;


public class InfiniteViewPager extends ViewPager {

    private InfiniteViewPagerAdapter mPageAdapter;

    private List<OnPageChangeListener> mOnPageChangeListenerList = new ArrayList<>();

    public InfiniteViewPager(Context context) {
        super(context);
        init();
    }

    public InfiniteViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        super.addOnPageChangeListener(mInnerOnPageChangeListener);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        mPageAdapter = new InfiniteViewPagerAdapter(adapter);
        mPageAdapter.setHasCaching(true);
//        setOffscreenPageLimit(mPageAdapter.getCount());
        super.setAdapter(mPageAdapter);
        setCurrentItem(0, false);
    }

    @Override
    public int getCurrentItem() {
        return mPageAdapter.calculateExactPosition(super.getCurrentItem());
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        int exactPosition = mPageAdapter.calculateAdapterPosition(item);
        super.setCurrentItem(exactPosition, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        if(getCurrentItem() != item){
            setCurrentItem(item, true);
        }
    }

    @Override
    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        mOnPageChangeListenerList.add(onPageChangeListener);
    }

    private OnPageChangeListener mInnerOnPageChangeListener = new OnPageChangeListener() {

        private int mPreviousPosition = -1;

        private float mPreviousPageOffset = -1f;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int exactPosition = mPageAdapter.calculateExactPosition(position);
            int lastAdapterPosition = mPageAdapter.getCount() - 1;
            if(mPreviousPageOffset == 0f && mPreviousPosition == 0 &&
                    (position == 0 || position == lastAdapterPosition)){
                setCurrentItem(exactPosition, false);
            }
            mPreviousPageOffset = positionOffset;
            int selectedPosition;
            float resultPositionOffset = 0f;
            int resultPositionOffsetPixels = 0;
            if(exactPosition != lastAdapterPosition){
                selectedPosition = exactPosition;
                resultPositionOffset = positionOffset;
                resultPositionOffsetPixels = positionOffsetPixels;
            } else {
                selectedPosition = positionOffset > 0.5f ? 0 : exactPosition;
            }
            for(OnPageChangeListener onPageChangeListener : mOnPageChangeListenerList){
                onPageChangeListener.onPageScrolled(selectedPosition, resultPositionOffset, resultPositionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
            int exactPosition = mPageAdapter.calculateExactPosition(position);
            if(exactPosition != mPreviousPosition){
                mPreviousPosition = exactPosition;
                for(OnPageChangeListener onPageChangeListener : mOnPageChangeListenerList){
                    onPageChangeListener.onPageSelected(exactPosition);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            int position = InfiniteViewPager.super.getCurrentItem();
            int exactPosition = mPageAdapter.calculateExactPosition(position);
            if(state == ViewPager.SCROLL_STATE_IDLE &&
                    (position == 0 || position == mPageAdapter.getCount() - 1)){
                setCurrentItem(exactPosition, false);
            }
            for(OnPageChangeListener onPageChangeListener : mOnPageChangeListenerList){
                onPageChangeListener.onPageScrollStateChanged(state);
            }
        }
    };
}

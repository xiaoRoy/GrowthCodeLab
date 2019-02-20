package com.learn.growthcodelab.view.viewpager;

import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.growthcodelab.BR;
import com.learn.growthcodelab.R;
import com.learn.growthcodelab.databinding.LayoutViewPagerItemLikeBinding;

import java.util.List;


public class LikePageAdapter extends PagerAdapter {

    private int mCurrentPosition;

    private List<Integer> mLikeList;

    public LikePageAdapter(List<Integer> likeList) {
        mLikeList = likeList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutViewPagerItemLikeBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(container.getContext()),
                                        R.layout.layout_view_pager_item_like,
                                        container,
                                        false);
        binding.setVariable(BR.position, position);
        binding.setVariable(BR.count, mLikeList.get(position));
        View viewItem = binding.getRoot();
        viewItem.setTag(mLikeList.get(position));
        container.addView(viewItem);
        return viewItem;
    }

    @Override
    public int getCount() {
        return mLikeList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getItemPosition(Object object) {
        int result = POSITION_UNCHANGED;
        int count = (Integer) ((View)object).getTag();
        if(count != mLikeList.get(mCurrentPosition)){
            result = POSITION_NONE;
        }
        return result;
    }

    @Override
    public void startUpdate(ViewGroup container) {
        super.startUpdate(container);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void updateLike(int count, int position){
        mCurrentPosition = position;
        mLikeList.set(position, count);
        notifyDataSetChanged();
    }
}

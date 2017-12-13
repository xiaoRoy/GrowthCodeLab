package com.learn.growthcodelab.playground;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.databinding.FragmentLikeBinding;
import com.learn.growthcodelab.fragment.BaseFragment;
import com.learn.growthcodelab.view.viewpager.LikePageAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LikeFragment extends BaseFragment implements View.OnClickListener{

    public static LikeFragment newInstance(){
        return new LikeFragment();
    }

    private List<Integer> mLikeList = new ArrayList<>();

    private FragmentLikeBinding mFragmentLikeBinding;

    private LikePageAdapter mLikePageAdapter;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_like;
    }

    @Override
    protected View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentLikeBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        mFragmentLikeBinding.setOnClickListener(this);
        return mFragmentLikeBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mLikeList.addAll(Arrays.asList(11, 15, 11, 65, 2, 3, 22, 19, 7, 5, 56, 34));
        mLikePageAdapter = new LikePageAdapter(mLikeList);
        mFragmentLikeBinding.viewPagerLike.setAdapter(mLikePageAdapter);
    }

    @Override
    public void onClick(View view) {
        int currentPosition = mFragmentLikeBinding.viewPagerLike.getCurrentItem();
        int count = mLikeList.get(currentPosition) + 1;
        mLikePageAdapter.updateLike(count, currentPosition);
    }
}

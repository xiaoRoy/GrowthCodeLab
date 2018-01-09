package com.learn.growthcodelab.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ViewFlipper;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.fragment.BaseFragment;



public class ViewAnimatorFragment extends BaseFragment implements View.OnClickListener{

    public static ViewAnimatorFragment newInstance(){
        return new ViewAnimatorFragment();
    }

    public ViewAnimatorFragment() {
    }

    private ViewFlipper mFlipperFirst;
    private View mViewCardTipsAnother, mViweCompleted;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_view_animator;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFlipperFirst = (ViewFlipper) view.findViewById(R.id.flipper_first);
        mViewCardTipsAnother = LayoutInflater.from(mFlipperFirst.getContext()).inflate(R.layout.layout_tips_another, mFlipperFirst, false);
        mViweCompleted = LayoutInflater.from(mFlipperFirst.getContext()).inflate(R.layout.layout_completed, mFlipperFirst, false);
        view.findViewById(R.id.btn_view_animator_change_tip).setOnClickListener(this);
        view.findViewById(R.id.btn_view_animator_change_another).setOnClickListener(this);
        view.findViewById(R.id.btn_view_animator_change_completed).setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_view_animator_change_tip:
                mFlipperFirst.setDisplayedChild(0);
                break;
            case R.id.btn_view_animator_change_another:
                mFlipperFirst.setDisplayedChild(1);
                break;
            case R.id.btn_view_animator_change_completed:
                mFlipperFirst.setDisplayedChild(2);
                break;
        }
    }
}

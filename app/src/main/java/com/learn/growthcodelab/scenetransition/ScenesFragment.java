package com.learn.growthcodelab.scenetransition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Scene;
import android.support.transition.TransitionManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.fragment.BaseFragment;


public class ScenesFragment extends BaseFragment implements View.OnClickListener{

    private FrameLayout mFlSceneRoot;
    private LinearLayout mLlSceneFirst;

    public static ScenesFragment newInstance(){
        return new ScenesFragment();
    }

    private Scene mFirstScene, mSecondScene;
    private View mViewChange;
    private TextView mTvFirstLine;


    public ScenesFragment() {
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_scenes;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFlSceneRoot = (FrameLayout)view.findViewById(R.id.fl_scene_root);
        mLlSceneFirst = (LinearLayout)view.findViewById(R.id.ll_scene_container);
        mTvFirstLine = (TextView) view.findViewById(R.id.tv_scene_first_line);
        mFirstScene = Scene.getSceneForLayout(mFlSceneRoot, R.layout.layout_scene_first, getActivity());
        mSecondScene = Scene.getSceneForLayout(mFlSceneRoot, R.layout.layout_scene_second, getActivity());
        mViewChange = view.findViewById(R.id.btn_scene_change);
        mViewChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mSecondScene.enter();
    }
}

package com.learn.growthcodelab.transition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Scene;
import android.support.transition.TransitionManager;
import android.view.View;
import android.widget.FrameLayout;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.fragment.BaseFragment;


public class ScenesFragment extends BaseFragment implements View.OnClickListener{

    public static ScenesFragment newInstance(){
        return new ScenesFragment();
    }

    private Scene firstScene, secondScene, currentScene;


    public ScenesFragment() {
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_scenes;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FrameLayout flSceneRoot = (FrameLayout) view.findViewById(R.id.fl_scene_root);
        firstScene = Scene.getSceneForLayout(flSceneRoot, R.layout.layout_scene_first, getActivity());
        secondScene = Scene.getSceneForLayout(flSceneRoot, R.layout.layout_scene_second, getActivity());
        View viewChange = view.findViewById(R.id.btn_scene_change);
        viewChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(currentScene == null){
            currentScene = secondScene;
        } else if(currentScene == firstScene){
            currentScene = secondScene;
        } else {
            currentScene = firstScene;
        }
        TransitionManager.go(currentScene);
    }
}

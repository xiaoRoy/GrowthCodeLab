package com.learn.growthcodelab.playground;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.AutoTransition;
import android.support.transition.ChangeBounds;
import android.support.transition.Fade;
import android.support.transition.Scene;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.fragment.BaseFragment;


public class SceneTransitionFragment extends BaseFragment implements View.OnClickListener {

    private View mViewCardFirst, mViewCardSecond;
    private Scene mFirstScene, mSecondScene;
    private Fade mFade;
    private FrameLayout mFlCardContainer;

    public static SceneTransitionFragment newInstance() {
        return new SceneTransitionFragment();
    }

    public SceneTransitionFragment() {
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_layout_transition;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewCardFirst = view.findViewById(R.id.card_first);
        mViewCardSecond = view.findViewById(R.id.card_second);
        mFlCardContainer = (FrameLayout) view.findViewById(R.id.fl_card_container);
        view.findViewById(R.id.btn_layout_transition_change).setOnClickListener(this);
        mFirstScene = Scene.getSceneForLayout(mFlCardContainer, R.layout.layout_first_card, getActivity());
        mSecondScene = Scene.getSceneForLayout(mFlCardContainer, R.layout.layout_second_card, getActivity());
        mViewCardFirst.setVisibility(View.VISIBLE);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_layout_transition_change:
//                TransitionManager.go(mSecondScene, new SlideTransition());
                TransitionManager.beginDelayedTransition(mFlCardContainer);
//                toggleVisibility(mViewCardFirst);
                break;
        }
    }

    private static void toggleVisibility(View view) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.INVISIBLE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

    private static class SlideTransition extends Transition {

        private static final String PROPERTY_NAME_TRANSLATION_X = "com.learn.growthcodelab:SlideTransition:x";

        @Override
        public void captureEndValues(@NonNull TransitionValues transitionValues) {
            System.out.println("trail.captureEndValues");
            View view = transitionValues.view;
            if (view.getId() == R.id.card_first) {
                transitionValues.values.put(PROPERTY_NAME_TRANSLATION_X, 0f);
            }
        }

        @Override
        public void captureStartValues(@NonNull TransitionValues transitionValues) {
            System.out.println("trail.captureStartValues");
            View view = transitionValues.view;
            if (view.getId() == R.id.card_first) {
                transitionValues.values.put(PROPERTY_NAME_TRANSLATION_X, view.getWidth() + 0.0f);
            }
        }

        @Nullable
        @Override
        public Animator createAnimator(@NonNull ViewGroup sceneRoot, @Nullable TransitionValues startValues, @Nullable TransitionValues endValues) {
            System.out.println("trail.createAnimator");
            if (startValues != null && endValues != null) {
                Animator animator = ObjectAnimator.ofFloat(endValues.view, "translationX", (Float) startValues.values.get(PROPERTY_NAME_TRANSLATION_X), (Float) endValues.values.get(PROPERTY_NAME_TRANSLATION_X));
                return animator.setDuration(800);
            } else {
                return super.createAnimator(sceneRoot, startValues, endValues);
            }
        }
    }
}

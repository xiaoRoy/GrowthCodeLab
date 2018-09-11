package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.scenetransition.ScenesFragment;
import com.learn.growthcodelab.transition.DelayedTransitionFragment;

public class TransitionActivity extends BaseActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context, TransitionActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_transition_container, DelayedTransitionFragment.Companion.newInstance())
                .commit();
    }
}

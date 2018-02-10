package com.learn.growthcodelab.fullscreen;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.fragment.BaseFragment;


public class StatusBarFragment extends BaseFragment {

    public static StatusBarFragment newInstance(){
        return new StatusBarFragment();
    }

    public StatusBarFragment() {
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_status_bar;
    }
}

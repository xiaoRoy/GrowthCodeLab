package com.learn.growthcodelab.fullscreen;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.databinding.FragmentFullScreenBinding;
import com.learn.growthcodelab.fragment.BaseFragment;


public class FullScreenFragment extends BaseFragment {

    private FullScreenNavigator mFullScreenNavigator;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mFullScreenNavigator = (FullScreenNavigator)context;
        } catch (ClassCastException exception) {
            throw new ClassCastException("Host Activity must implement FullScreenNavigator");
        }
    }

    public static FullScreenFragment newInstance(){
        return new FullScreenFragment();
    }

    public FullScreenFragment() {
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_full_screen;
    }

    @Override
    protected View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentFullScreenBinding binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        binding.setNavigator(mFullScreenNavigator);
        return binding.getRoot();
    }
}

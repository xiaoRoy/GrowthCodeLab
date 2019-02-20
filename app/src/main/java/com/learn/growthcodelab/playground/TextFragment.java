package com.learn.growthcodelab.playground;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.databinding.FragmentTextBinding;
import com.learn.growthcodelab.fragment.BaseFragment;

public class TextFragment extends BaseFragment {

    private FragmentTextBinding mFragmentTextBinding;

    public static TextFragment newInstance(){
        return new TextFragment();
    }

    public TextFragment() {
    }

    @Override
    protected View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentTextBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        return mFragmentTextBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mFragmentTextBinding.textInputUserName.setHint("Your Name");
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_text;
    }
}

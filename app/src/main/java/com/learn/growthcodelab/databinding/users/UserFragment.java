package com.learn.growthcodelab.databinding.users;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.databinding.FragmentUserBinding;
import com.learn.growthcodelab.databinding.model.User;
import com.learn.growthcodelab.fragment.BaseFragment;


public class UserFragment extends BaseFragment implements UserClickHandler{

    private FragmentUserBinding mFragmentUserBinding;

    public static UserFragment newInstance(){
        return new UserFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_user;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentUserBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        return mFragmentUserBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentUserBinding.setUser(new User("Will", "Smith"));
        mFragmentUserBinding.setUserClickHandler(this);
    }

    @Override
    public void onShowMessageClicked(User user) {
        Toast.makeText(getActivity(),
                       getString(R.string.s_data_binding_user_hello, user.getFirstName(),
                       user.getLastName()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changUserName(User user) {
        user.setFirstName("Ryan");
        user.setLastName("Tony");
    }
}

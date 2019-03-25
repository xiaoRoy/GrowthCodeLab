package com.learn.growthcodelab.databinding.login;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.databinding.FragmentLoginBinding;
import com.learn.growthcodelab.fragment.BaseFragment;


public class LoginFragment extends BaseFragment implements LoginContracts.View{

    private LoginContracts.Presenter mLoginPresenter;

    public static LoginFragment newInstance(){
        return new LoginFragment();
    }

    public LoginFragment(){

    }

    private LoginViewModel mLoginViewModel;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_login;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentLoginBinding fragmentLoginBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        fragmentLoginBinding.setLoginViewModel(mLoginViewModel);
        return fragmentLoginBinding.getRoot();
    }

    @Override
    public void setPresenter(LoginContracts.Presenter presenter) {
        mLoginPresenter = presenter;
    }

    @Override
    public void showPasswordHint(String passwordHint) {
    }

    public void setLoginViewModel(LoginViewModel loginViewModel) {
        mLoginViewModel = loginViewModel;
    }
}

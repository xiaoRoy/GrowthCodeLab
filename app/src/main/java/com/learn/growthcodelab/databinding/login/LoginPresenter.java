package com.learn.growthcodelab.databinding.login;

public class LoginPresenter implements LoginContracts.Presenter {


    private final LoginContracts.View mView;

    public LoginPresenter(LoginContracts.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void login(String password) {

    }
}

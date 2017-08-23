package com.learn.growthcodelab.databinding.login;

public interface LoginContracts {

    interface View{

        void setPresenter(Presenter presenter);

        void showPasswordHint(String passwordHint);
    }

    interface Presenter{
        void login(String password);
    }
}

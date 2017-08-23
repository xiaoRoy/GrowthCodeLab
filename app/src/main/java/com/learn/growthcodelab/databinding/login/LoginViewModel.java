package com.learn.growthcodelab.databinding.login;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextWatcher;

import com.learn.growthcodelab.BR;
import com.learn.growthcodelab.widget.SimpelTextWatchter;


public class LoginViewModel extends BaseObservable {

    private String mPassword;

    private LoginPresenter mLoginPresenter;

    public LoginViewModel(LoginPresenter loginPresenter) {
        mLoginPresenter = loginPresenter;
    }

    @Bindable
    public String getVerifiedPasswordHint(){
        if (mPassword == null || mPassword.isEmpty()) {
            return "Enter a password";
        } else if (mPassword.equals("password")) {
            return "Very bad";
        } else if (mPassword.length() < 6) {
            return "Short";
        } else {
            return "Okay";
        }
    }

    public void setPassword(String password) {
        mPassword = password;
        notifyPropertyChanged(BR.verifiedPasswordHint);
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getPassword() {
        return mPassword;
    }

    public TextWatcher getTextWatcher(){
        return new SimpelTextWatchter(){
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                setPassword(charSequence.toString());
            }
        };
    }
}

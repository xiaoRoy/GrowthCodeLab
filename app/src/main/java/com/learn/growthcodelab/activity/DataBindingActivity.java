package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.databinding.ActivityDataBindingBinding;
import com.learn.growthcodelab.databinding.login.LoginFragment;
import com.learn.growthcodelab.databinding.login.LoginPresenter;
import com.learn.growthcodelab.databinding.login.LoginViewModel;
import com.learn.growthcodelab.databinding.users.UserFragment;
import com.learn.growthcodelab.databinding.notes.NotesFragment;


public class DataBindingActivity extends BaseActivity {

    private LoginPresenter mLoginPresenter;

    public static void start(Context context) {
        context.startActivity(new Intent(context, DataBindingActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingBinding activityDataBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        activityDataBindingBinding.setClickHandler(new ClickHandler());

    }

    public class ClickHandler{
        public void onUserClick(View view){
              getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_data_binding_container, UserFragment.newInstance())
                        .addToBackStack("user_replace")
                        .commit();
        }

        public void onNotesClick(View view){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_data_binding_container, NotesFragment.newInstance())
                    .addToBackStack("notes_replace")
                    .commit();
        }

        public void onLoginClick(View view){
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fl_data_binding_container);
            if(!(fragment instanceof LoginFragment)){
                LoginFragment loginFragment = LoginFragment.newInstance();
                mLoginPresenter = new LoginPresenter(loginFragment);
                LoginViewModel loginViewModel = new LoginViewModel(mLoginPresenter);
                loginFragment.setLoginViewModel(loginViewModel);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_data_binding_container, loginFragment)
                        .addToBackStack("login_replace")
                        .commit();
            }
        }
    }
}

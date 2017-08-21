package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.databinding.ActivityDataBindingBinding;
import com.learn.growthcodelab.databinding.Users.UserFragment;
import com.learn.growthcodelab.databinding.notes.NotesFragment;


public class DataBindingActivity extends BaseActivity {

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
    }
}

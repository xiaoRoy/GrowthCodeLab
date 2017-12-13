package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.playground.LikeFragment;
import com.learn.growthcodelab.playground.PhoneNumberFragment;


public class PlayGroundActivity extends AppCompatActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context, PlayGroundActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_play_ground_container, LikeFragment.newInstance(), "Like")
                .addToBackStack(null)
                .commit();
    }
}

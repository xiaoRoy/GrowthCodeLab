package com.learn.growthcodelab.handler;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Message;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.activity.BaseActivity;
import com.learn.growthcodelab.databinding.ActivityHandlerBinding;


public class HandlerActivityJ extends BaseActivity
                implements LooperThreadJ.HandleMessageCallback, View.OnClickListener{

    private static final String TAG = "HandlerActivityJ";

    public static void start(Context context){
        context.startActivity(new Intent(context, HandlerActivityJ.class));
    }

    private LooperThreadJ mLooperThreadJ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHandlerBinding handlerBinding
                        = DataBindingUtil.setContentView(this, R.layout.activity_handler);
        handlerBinding.setOnClickListener(this);
        mLooperThreadJ = new LooperThreadJ(this);
        mLooperThreadJ.start();
    }

    @Override
    public void handle() {
        System.out.println("trail.threadName:" + Thread.currentThread().getName());
        Log.d(TAG, "handed");
    }

    @Override
    public void onClick(View view) {
        if(mLooperThreadJ != null){
            Message message = mLooperThreadJ.mHandler.obtainMessage(0);
            mLooperThreadJ.mHandler.sendMessage(message);
        }
    }

    @Override
    protected void onDestroy() {
        mLooperThreadJ.mHandler.getLooper().quit();
        super.onDestroy();
    }
}

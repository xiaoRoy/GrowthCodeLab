package com.learn.growthcodelab.handler;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.activity.BaseActivity;
import com.learn.growthcodelab.databinding.ActivityHandlerBinding;


public class HandlerActivity extends BaseActivity
                implements LooperThread.HandleMessageCallback, View.OnClickListener{

    private static final String TAG = "HandlerActivity";

    public static void start(Context context){
        context.startActivity(new Intent(context, HandlerActivity.class));
    }

    private LooperThread mLooperThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHandlerBinding handlerBinding
                        = DataBindingUtil.setContentView(this, R.layout.activity_handler);
        handlerBinding.setOnClickListener(this);
        mLooperThread = new LooperThread(this);
        mLooperThread.start();
    }

    @Override
    public void handle() {
        System.out.println("trail.threadName:" + Thread.currentThread().getName());
        Log.d(TAG, "handed");
    }

    @Override
    public void onClick(View view) {
        if(mLooperThread != null){
            Message message = mLooperThread.mHandler.obtainMessage(0);
            mLooperThread.mHandler.sendMessage(message);
        }
    }

    @Override
    protected void onDestroy() {
        mLooperThread.mHandler.getLooper().quit();
        super.onDestroy();
    }
}

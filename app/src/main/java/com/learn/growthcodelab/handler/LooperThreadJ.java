package com.learn.growthcodelab.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class LooperThreadJ extends Thread {

    public Handler mHandler;

    private final HandleMessageCallback mHandleMessageCallback;

    public LooperThreadJ(HandleMessageCallback handleMessageCallback) {
        mHandleMessageCallback = handleMessageCallback;
    }

    @Override
    public void run() {
        Looper.prepare();
        mHandler = new LooperHandler(mHandleMessageCallback);
        Looper.loop();

    }

    private static class LooperHandler extends Handler{
        private final HandleMessageCallback mHandleMessageCallback;

        LooperHandler(HandleMessageCallback handleMessageCallback) {
            mHandleMessageCallback = handleMessageCallback;
        }

        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0){
                mHandleMessageCallback.handle();
            }
        }
    }

    public interface HandleMessageCallback{
        void handle();
    }
}

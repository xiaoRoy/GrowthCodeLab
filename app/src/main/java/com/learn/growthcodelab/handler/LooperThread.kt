package com.learn.growthcodelab.handler

import android.os.Handler
import android.os.Looper

class LooperThread(val callback: Handler.Callback) : Thread() {

    lateinit var handler: Handler

    override fun run() {
        Looper.prepare()
        handler = Handler(callback)
        Looper.loop()
    }
}
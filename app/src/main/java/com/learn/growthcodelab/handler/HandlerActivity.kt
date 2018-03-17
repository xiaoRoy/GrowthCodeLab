package com.learn.growthcodelab.handler

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.PersistableBundle
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityHandlerBinding

class HandlerActivity : BaseActivity(), Handler.Callback{

    private lateinit var looperThread: LooperThread

    companion object {
        fun start(context: Context){
            val intent = Intent(context, HandlerActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val handlerBinding: ActivityHandlerBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_handler)
        looperThread = LooperThread(this)
        looperThread.start()
        handlerBinding.setOnClickListener{ _ ->
            val msg = looperThread.handler.obtainMessage(0)
            looperThread.handler.sendMessage(msg)
        }
    }

    override fun handleMessage(msg: Message?): Boolean {
        if(msg?.what == 0){
            println("trail.threadName: ${Thread.currentThread().name}")
        }
        return true
    }
}
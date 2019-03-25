package com.learn.growthcodelab.handler

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.SystemClock
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityHandlerBinding
import java.util.*

class HandlerActivity : BaseActivity(), Handler.Callback{

    private lateinit var consumeAndQuitThread: ConsumeAndQuitThread

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
        consumeAndQuitThread = ConsumeAndQuitThread(handlerCallback = this)
        consumeAndQuitThread.start()
        handlerBinding.setOnClickListener{ _ ->
                Thread{
                    for(i in 1 .. 10){
                        consumeAndQuitThread.insertMsg(i)
                    }
                }.start()
        }
    }

    override fun handleMessage(msg: Message?): Boolean {
        msg?.let {
            println("trail.threadName:${Thread.currentThread().name}")
            println("trail.msg:${it.what}")
        }
        return true
    }

    override fun onDestroy() {
        consumeAndQuitThread.consumerHandler.looper.quit()
        super.onDestroy()
    }
}
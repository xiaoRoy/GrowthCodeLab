package com.learn.growthcodelab.handler

import android.os.Handler
import android.os.Looper
import android.os.MessageQueue

class ConsumeAndQuitThread(var isFirstIdle: Boolean = true,
                           private val handlerCallback: Handler.Callback)
                                : Thread(THREAD_NAME), MessageQueue.IdleHandler {

    companion object {
        private const val THREAD_NAME = "ConsumeAndQuitThread"
    }

    lateinit var consumerHandler: Handler

    override fun run() {
        Looper.prepare()
        consumerHandler = Handler(handlerCallback)
        Looper.myQueue().addIdleHandler(this)
        Looper.loop()
    }

    override fun queueIdle(): Boolean {
        if(isFirstIdle){
            isFirstIdle = false
            return true
        }
        consumerHandler.looper.quit()
        println("trail.quit")
        return false
    }

    fun insertMsg(index: Int){
        consumerHandler.sendEmptyMessage(index)
    }


}
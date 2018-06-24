package com.learn.growthcodelab.touchagain

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity

class TouchAgainActivity : BaseActivity() {

    companion object {
        const val TAG = "TOUCH_AGAIN"
        fun start(context: Context) {
            context.startActivity(Intent(context, TouchAgainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_again)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> Log.i(TAG, "TouchAgainActivity.ouTouchEvent.ACTION_DOWN")
                MotionEvent.ACTION_MOVE -> Log.i(TAG, "TouchAgainActivity.ouTouchEvent.ACTION_MOVE")
                MotionEvent.ACTION_UP -> Log.i(TAG, "TouchAgainActivity.ouTouchEvent.ACTION_UP")
                else -> throw IllegalArgumentException()
            }
        }
        return super.onTouchEvent(event)
    }

}
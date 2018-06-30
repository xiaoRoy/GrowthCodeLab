package com.learn.growthcodelab.touchagain

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity

class TouchAgainActivity : BaseActivity() {

    companion object {
        const val TAG = "TOUCH_AGAIN"
        fun start(context: Context) {
            context.startActivity(Intent(context, TouchAgainActivity::class.java))
        }
    }

    private lateinit var btnNotConsumeMoveAndUp: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_again)
        btnNotConsumeMoveAndUp = findViewById(R.id.btn_touch_not_consume_move_and_up)

       /* btnNotConsumeMoveAndUp.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                Log.i(TAG, "Button.onTouch")
                return event?.action == MotionEvent.ACTION_DOWN
            }
        })*/
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i(TAG, "TouchAgainActivity.ouTouchEvent")
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

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.i(TAG, "TouchAgainActivity.dispatchTouchEvent")
        event?.let {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> Log.i(TAG, "TouchAgainActivity.dispatchTouchEvent.ACTION_DOWN")
                MotionEvent.ACTION_MOVE -> Log.i(TAG, "TouchAgainActivity.dispatchTouchEvent.ACTION_MOVE")
                MotionEvent.ACTION_UP -> Log.i(TAG, "TouchAgainActivity.dispatchTouchEvent.ACTION_UP")
                else -> throw IllegalArgumentException()
            }
        }
        val result = super.dispatchTouchEvent(event)
        Log.i(TAG, "TouchAgainActivity.dispatchTouchEvent.result:$result")
        return result
    }

}
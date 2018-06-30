package com.learn.growthcodelab.touchagain

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Button

class NotConsumeMoveAndUpButton : Button{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        return event?.action == MotionEvent.ACTION_DOWN
    }
}
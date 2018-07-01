package com.learn.growthcodelab.window

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.touchagain.TouchAgainActivity

class WindowActivity: BaseActivity() {

    companion object {
        fun start(context: Context){
            context.startActivity(Intent(context, WindowActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window)
    }
}
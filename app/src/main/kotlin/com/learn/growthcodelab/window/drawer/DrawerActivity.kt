package com.learn.growthcodelab.window.drawer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity

class DrawerActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, DrawerActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
    }
}
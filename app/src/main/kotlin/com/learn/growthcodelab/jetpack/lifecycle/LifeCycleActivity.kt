package com.learn.growthcodelab.jetpack.lifecycle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Chronometer
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity

class LifeCycleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        val chronometer = findViewById<Chronometer>(R.id.chronometer_life_cycle)
        chronometer.start()
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, LifeCycleActivity::class.java))
        }
    }
}
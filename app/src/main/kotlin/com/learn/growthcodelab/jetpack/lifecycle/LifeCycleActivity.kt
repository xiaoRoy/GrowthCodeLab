package com.learn.growthcodelab.jetpack.lifecycle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import java.lang.StringBuilder

class LifeCycleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        useChronometerViewModel()
        useTimerViewModel()

    }

    private fun useChronometerViewModel() {
        val chronometer = findViewById<Chronometer>(R.id.chronometer_life_cycle)

        val chronometerViewModel = ViewModelProviders.of(this).get(ChronometerViewModel::class.java)
        val tempStartTime = chronometerViewModel.startTime
        if (tempStartTime == null) {
            val startTime = SystemClock.elapsedRealtime()
            chronometerViewModel.startTime = startTime
            chronometer.base = startTime
        } else {
            chronometer.base = tempStartTime
        }
        chronometer.start()
    }

    private fun useTimerViewModel() {
        val tvTimer = findViewById<TextView>(R.id.tv_lifecycle_timer)
        val timerViewModel = ViewModelProviders.of(this).get(TimerViewModel::class.java)
        timerViewModel.elapsedTime.observe(this, Observer {
            val resultStringBuilder = StringBuilder()
            resultStringBuilder.append(it)
            val second = if(it == 1L) {
                " second "
            } else {
                " seconds "
            }
            resultStringBuilder.append(second)
            resultStringBuilder.append("elapsed")
            tvTimer.text = resultStringBuilder.toString()
        })
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, LifeCycleActivity::class.java))
        }
    }
}
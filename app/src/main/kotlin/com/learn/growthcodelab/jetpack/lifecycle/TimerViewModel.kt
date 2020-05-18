package com.learn.growthcodelab.jetpack.lifecycle

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import java.util.concurrent.TimeUnit

class TimerViewModel : ViewModel() {

    private val initialTime = SystemClock.elapsedRealtime()

    private val timer = Timer()

    init {
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / MILLI_SECOND_IN_ONE_SECOND
                _elapsedTime.postValue(newValue)
            }
        }, ONE_SECOND, ONE_SECOND)

    }

    private val _elapsedTime = MutableLiveData<Long>()
    val elapsedTime: LiveData<Long>
        get() = _elapsedTime

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

    companion object {
        const val ONE_SECOND = 1000L
        const val MILLI_SECOND_IN_ONE_SECOND = 1000L
    }
}
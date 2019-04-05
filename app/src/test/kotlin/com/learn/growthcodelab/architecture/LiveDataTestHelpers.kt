package com.learn.growthcodelab.architecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


@Suppress("UNCHECKED_CAST")
fun <T> getValue(liveData: LiveData<T>): T {
    val data = arrayOfNulls<Any>(1)
    val countDownLatch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(value: T) {
            data[0] = value
//            countDownLatch.countDown()
            liveData.removeObserver(this)
        }
    }
    liveData.observeForever(observer)
//    countDownLatch.await(2, TimeUnit.SECONDS)
    return data[0] as T
}
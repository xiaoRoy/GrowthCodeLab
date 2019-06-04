package com.learn.growthcodelab

import androidx.annotation.IdRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.growthcodelab.architecture.mvvmlive.Event

class MainActivityViewModel : ViewModel() {

    private val navigation: MutableLiveData<Event<Int>> = MutableLiveData()

    fun navigate(@IdRes destination: Int) {
        navigation.value = Event(destination)
    }

    fun getNavigation() : LiveData<Event<Int>> = navigation
}
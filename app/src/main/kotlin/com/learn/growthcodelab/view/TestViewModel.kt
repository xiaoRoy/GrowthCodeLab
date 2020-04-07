package com.learn.growthcodelab.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    val isTopChoice =  MutableLiveData<Boolean>()
}
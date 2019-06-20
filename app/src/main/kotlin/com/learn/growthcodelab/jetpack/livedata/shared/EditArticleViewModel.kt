package com.learn.growthcodelab.jetpack.livedata.shared

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EditArticleViewModel : ViewModel() {

    val title: MutableLiveData<String> = MutableLiveData()
}
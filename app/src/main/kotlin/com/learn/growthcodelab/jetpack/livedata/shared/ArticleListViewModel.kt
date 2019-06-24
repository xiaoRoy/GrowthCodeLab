package com.learn.growthcodelab.jetpack.livedata.shared

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArticleListViewModel : ViewModel() {


    private val _likeAmount: MutableLiveData<Int> = MutableLiveData()

    val likeAmount: LiveData<Int>
        get() = _likeAmount

    fun like() {
        var amount = _likeAmount.value ?: 0
        _likeAmount.value = ++amount
    }
}
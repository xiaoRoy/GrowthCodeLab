package com.learn.growthcodelab.jetpack.livedata.shared

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.growthcodelab.architecture.mvvmlive.Event

class ArticleSharedViewModel : ViewModel() {

    private val _navigateToArticleDetail: MutableLiveData<Event<String>> = MutableLiveData()
    val navigateToArticleDetail: LiveData<Event<String>>
        get() = _navigateToArticleDetail


    fun navigateToArticleDetail(title: String) {
        _navigateToArticleDetail.value = Event(title)
    }

    private val _navigateToEditArticle: MutableLiveData<Event<String>> = MutableLiveData()
    val navigateToEditArticle: LiveData<Event<String>> = _navigateToEditArticle

    fun navigateToEditArticle(title: String) {
        _navigateToEditArticle.value = Event(title)
    }

    private val _titleUpdated: MutableLiveData<Event<String>> = MutableLiveData()
    val titleUpdated: MutableLiveData<Event<String>>
        get() = _titleUpdated

    private val titleUpdatedAnother = MutableLiveData<Event<String>>()

    fun getTitleUpdated(): LiveData<Event<String>> = titleUpdatedAnother

    fun updateTitle(title: String) {
        titleUpdatedAnother.value = Event(title)
    }

}
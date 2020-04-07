package com.learn.growthcodelab.jetpack.livedata.shared

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learn.growthcodelab.architecture.mvvmlive.Event

class EditArticleViewModel(private val sharedViewModel: ArticleSharedViewModel) : ViewModel() {

    val title: MutableLiveData<String> = MutableLiveData()

    fun saveArticleTitle() {
        title.value?.run { sharedViewModel.titleUpdated.value = Event(this) }
    }
}

class EditArticleViewModelFactory private constructor(
        private val sharedViewModel: ArticleSharedViewModel
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return with(modelClass) {
            when {
                isAssignableFrom(EditArticleViewModel::class.java) ->
                    EditArticleViewModel(sharedViewModel)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

    }

    companion object {

        @Volatile
        private var INSTANCE: EditArticleViewModelFactory? = null

        fun genInstance(sharedViewModel: ArticleSharedViewModel) =
                INSTANCE ?: synchronized(EditArticleViewModelFactory::class.java) {
                    INSTANCE ?: EditArticleViewModelFactory(sharedViewModel)
                            .also { INSTANCE = it }
                }
    }
}
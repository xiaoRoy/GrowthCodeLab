package com.learn.growthcodelab.architecture.jetpack.word.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.learn.growthcodelab.architecture.jetpack.word.data.WordDataSource
import com.learn.growthcodelab.architecture.jetpack.word.model.Word
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class WordsViewModel(val wordDataSource: WordDataSource) : ViewModel() {

    val allWordList = MutableLiveData<List<Word>>()

    fun loadAllWords() {
        wordDataSource.getAllWords().subscribe(
                object : SingleObserver<List<Word>>{
                    override fun onSuccess(allWords: List<Word>) {
                        allWordList.value = allWords
                    }

                    override fun onSubscribe(d: Disposable) {
                        TODO("not implemented")
                    }

                    override fun onError(e: Throwable) {
                        TODO("not implemented")
                    }
                }
        )
    }
}
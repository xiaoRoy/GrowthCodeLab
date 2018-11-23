package com.learn.growthcodelab.architecture.jetpack.word.data

import android.arch.lifecycle.LiveData
import com.learn.growthcodelab.architecture.jetpack.word.model.Word
import io.reactivex.Completable
import io.reactivex.Single

interface WordDataSource {

    fun getAllWords(): LiveData<List<Word>>

    fun getAllWordsList(): List<Word>

    fun addWord(word: Word)
}
package com.learn.growthcodelab.architecture.jetpack.word.data

import com.learn.growthcodelab.architecture.jetpack.word.model.Word
import io.reactivex.Completable
import io.reactivex.Single

interface WordDataSource {

    fun getAllWords(): Single<List<Word>>

    fun addWord(word: Word): Completable
}
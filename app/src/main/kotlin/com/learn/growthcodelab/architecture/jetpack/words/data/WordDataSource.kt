package com.learn.growthcodelab.architecture.jetpack.words.data

import com.learn.jetpack.words.model.Word
import io.reactivex.Completable
import io.reactivex.Single

interface WordDataSource {

    fun getAllWords(): Single<List<Word>>

    fun addWord(word: Word): Completable
}
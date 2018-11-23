package com.learn.growthcodelab.architecture.jetpack.word.data

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import com.learn.growthcodelab.architecture.jetpack.word.model.Word

class WordRepository(private val wordDao: WordDao) : WordDataSource {

    override fun getAllWords(): LiveData<List<Word>> {
        return wordDao.getAllWords()
    }

    override fun getAllWordsList(): List<Word> {
        return wordDao.getAllWordList()
    }

    @WorkerThread
    override fun addWord(word: Word) {
        wordDao.insert(word)
    }

}
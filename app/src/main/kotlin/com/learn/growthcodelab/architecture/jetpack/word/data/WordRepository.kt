package com.learn.growthcodelab.architecture.jetpack.word.data

import androidx.lifecycle.LiveData
import com.learn.growthcodelab.architecture.jetpack.word.data.persistance.AddWordAsyncTask
import com.learn.growthcodelab.architecture.jetpack.word.data.persistance.WordDao
import com.learn.growthcodelab.architecture.jetpack.word.model.Word

class WordRepository(private val wordDao: WordDao) : WordDataSource {

    override fun getAllWords(): LiveData<List<Word>> {
        return wordDao.getAllWords()
    }

    override fun getAllWordsList(): List<Word> {
        return wordDao.getAllWordList()
    }

    override fun addWord(word: Word) {
        AddWordAsyncTask(wordDao).execute(word)
    }
}
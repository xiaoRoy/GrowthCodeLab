package com.learn.growthcodelab.architecture.jetpack.word.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.learn.growthcodelab.architecture.jetpack.word.data.WordRepository
import com.learn.growthcodelab.architecture.jetpack.word.data.persistance.WordRoomDatabase
import com.learn.growthcodelab.architecture.jetpack.word.model.Word

class WordsViewModel(application: Application) : AndroidViewModel(application) {

    private val wordRepository: WordRepository

    val allWords: LiveData<List<Word>>

    init {
        val wordDao = WordRoomDatabase.getDatabase(application).wordDao()
        wordRepository = WordRepository(wordDao)
        allWords = wordRepository.getAllWords()
    }

    fun addWord(word: Word) {
        wordRepository.addWord(word)
    }
}
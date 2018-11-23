package com.learn.growthcodelab.architecture.jetpack.word.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.learn.growthcodelab.architecture.jetpack.word.data.WordRepository
import com.learn.growthcodelab.architecture.jetpack.word.data.WordRoomDatabase
import com.learn.growthcodelab.architecture.jetpack.word.model.Word
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.Main
import kotlin.coroutines.experimental.CoroutineContext

class WordsViewModelUsingCoroutines(application: Application) : AndroidViewModel(application) {

    private var parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    private val wordRepository: WordRepository

    val allWordList: LiveData<List<Word>>

    init {
        val wordDao = WordRoomDatabase.getDatabase(application).wordDao()
        wordRepository = WordRepository(wordDao)
        allWordList = wordDao.getAllWords()
    }

    fun insert(word: Word) = scope.launch(Dispatchers.IO) {
        wordRepository.addWord(word)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

    fun loadAllWords() {
        /* wordDataSource.getAllWords().subscribe(
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
         )*/
    }
}
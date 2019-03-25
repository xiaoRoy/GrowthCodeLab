package com.learn.growthcodelab.architecture.jetpack.word.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.learn.growthcodelab.architecture.jetpack.word.data.WordRepository
import com.learn.growthcodelab.architecture.jetpack.word.data.persistance.WordRoomDatabase
import com.learn.growthcodelab.architecture.jetpack.word.model.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


/*
* Is it OK to put the Coroutine in the ViewModel?
* */
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
package com.learn.growthcodelab.architecture.jetpack.word.data.persistance

import android.os.AsyncTask
import com.learn.growthcodelab.architecture.jetpack.word.model.Word

class AddWordAsyncTask(private val wordDao: WordDao) : AsyncTask<Word, Unit, Unit>() {

    override fun doInBackground(vararg params: Word?) {
        params[0]?.let {
            wordDao.insert(it)
        }
    }
}
package com.learn.growthcodelab.architecture.jetpack.word.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.learn.growthcodelab.architecture.jetpack.word.model.Word

@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM word")
    fun deleteAll()

    @Query("SELECT * FROM word ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>

    @Query("SELECT * FROM word ORDER BY word ASC")
    fun getAllWordList(): List<Word>
}
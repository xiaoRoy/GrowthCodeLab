package com.learn.growthcodelab.architecture.jetpack.word.data.persistance

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
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
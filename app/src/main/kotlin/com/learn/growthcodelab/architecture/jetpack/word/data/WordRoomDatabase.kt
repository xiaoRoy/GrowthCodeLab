package com.learn.growthcodelab.architecture.jetpack.word.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.learn.growthcodelab.architecture.jetpack.word.model.Word


@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase(){
    companion object {
        private var INSTANCE : WordRoomDatabase? = null
    }

    abstract fun wordDao(): WordDao
}
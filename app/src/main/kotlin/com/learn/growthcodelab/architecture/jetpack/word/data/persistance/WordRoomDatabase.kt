package com.learn.growthcodelab.architecture.jetpack.word.data.persistance

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.learn.growthcodelab.architecture.jetpack.word.model.Word


@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        WordRoomDatabase::class.java,
                        "Word_database")
                        .addCallback(callback)
                        .build()
                INSTANCE = instance
                return instance
            }
        }

        private val callback = object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let {
                    PopulateDatabaseAsyncTask(it.wordDao()).execute()
                }
            }
        }
    }

    abstract fun wordDao(): WordDao
}
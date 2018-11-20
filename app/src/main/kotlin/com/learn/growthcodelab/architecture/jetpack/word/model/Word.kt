package com.learn.growthcodelab.architecture.jetpack.word.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "word")
class Word (@PrimaryKey @ColumnInfo(name = "word") val word: Word)
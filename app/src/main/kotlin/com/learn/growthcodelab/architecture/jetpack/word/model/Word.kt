package com.learn.growthcodelab.architecture.jetpack.word.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word")
class Word (@PrimaryKey @ColumnInfo(name = "word") val word: String)
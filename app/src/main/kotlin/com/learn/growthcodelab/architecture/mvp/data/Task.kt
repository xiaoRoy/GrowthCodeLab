package com.learn.growthcodelab.architecture.mvp.data

import java.util.UUID

data class Task (
        val id: String,
        val title: String,
        val description: String = UUID.randomUUID().toString(),
        val isCompleted: Boolean = false) {


    override fun toString() = "Task with title $title"
}
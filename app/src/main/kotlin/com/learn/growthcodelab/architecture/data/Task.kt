package com.learn.growthcodelab.architecture.data

import java.util.UUID

data class Task (
        val description: String,
        val title: String,
        val id: String = UUID.randomUUID().toString(),
        var isCompleted: Boolean = false) {

    val isActive: Boolean
    get() = !isCompleted

    override fun toString() = "Task with title $title"
}
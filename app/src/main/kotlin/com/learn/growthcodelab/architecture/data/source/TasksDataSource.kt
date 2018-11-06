package com.learn.growthcodelab.architecture.data.source

import com.learn.growthcodelab.architecture.data.Task

interface TasksDataSource {

    interface LoadAllTasksCallback {

        fun onAllTasksLoaded(allTasks: List<Task>)

        fun onAllTasksNotAvailable()
    }

    interface LoadSingleTaskCallback {

    }

    fun refreshTasks()

    fun loadAllTasks(callback: LoadAllTasksCallback)

    fun deleteAllTasks()

    fun saveTask(task: Task)
}
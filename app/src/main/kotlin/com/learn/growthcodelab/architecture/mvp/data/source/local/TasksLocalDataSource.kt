package com.learn.growthcodelab.architecture.mvp.data.source.local

import com.learn.growthcodelab.architecture.mvp.data.Task
import com.learn.growthcodelab.architecture.mvp.data.source.TasksDataSource

class TasksLocalDataSource : TasksDataSource{
    override fun refreshTasks() {
        TODO("not implemented")
    }

    override fun saveTask(task: Task) {
        TODO("not implemented")
    }

    override fun loadAllTasks(callback: TasksDataSource.LoadAllTasksCallback) {
        TODO("not implemented")
    }

    override fun deleteAllTasks() {
        TODO("not implemented")
    }
}
package com.learn.growthcodelab.architecture.data.source.remote

import com.learn.growthcodelab.architecture.data.Task
import com.learn.growthcodelab.architecture.data.source.TasksDataSource

object TasksRemoteDataSource : TasksDataSource {


    override fun loadAllTasks(callback: TasksDataSource.LoadAllTasksCallback) {
        TODO("not implemented")
    }

    override fun deleteAllTasks() {
        TODO("not implemented")
    }

    override fun saveTask(task: Task) {
        TODO("not implemented")
    }

    override fun loadSingleTaks(taskId: String, loadSingleTaskCallback: TasksDataSource.LoadSingleTaskCallback) {
        TODO("not implemented")
    }

    override fun refreshTasks() {
        TODO("not implemented")
    }
}
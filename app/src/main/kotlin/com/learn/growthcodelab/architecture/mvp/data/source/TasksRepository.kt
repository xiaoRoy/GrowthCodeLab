package com.learn.growthcodelab.architecture.mvp.data.source

import com.learn.growthcodelab.architecture.mvp.data.source.local.TasksLocalDataSource
import com.learn.growthcodelab.architecture.mvp.data.source.remote.TasksRemoteDataSource

class TasksRepository
constructor(val tasksLocalDataSource: TasksLocalDataSource,
            val tasksRemoteDataSource: TasksRemoteDataSource) : TasksDataSource {

    override fun loadAllTasks(callback: TasksDataSource.LoadAllTasksCallback) {
        TODO("not implemented")
    }

    internal var isCacheDirty = false

    override fun refreshTasks() {
        isCacheDirty = true
    }

}
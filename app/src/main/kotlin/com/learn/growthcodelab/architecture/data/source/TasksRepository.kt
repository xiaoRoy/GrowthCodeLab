package com.learn.growthcodelab.architecture.data.source

import com.learn.growthcodelab.architecture.data.Task
import com.learn.growthcodelab.architecture.data.source.local.TasksLocalDataSource
import com.learn.growthcodelab.architecture.data.source.remote.TasksRemoteDataSource

class TasksRepository constructor(
        private val tasksLocalDataSource: TasksLocalDataSource,
        private val tasksRemoteDataSource: TasksRemoteDataSource
) : TasksDataSource {


    var isCacheDirty = false

    var cacheTasks: LinkedHashMap<String, Task> = LinkedHashMap()

    override fun loadAllTasks(callback: TasksDataSource.LoadAllTasksCallback) {
        if (cacheTasks.isNotEmpty() && !isCacheDirty) {
            callback.onAllTasksLoaded(cacheTasks.values.toMutableList())
        }

        if (isCacheDirty) {
            loadAllTasksFromRemoteSource(callback)
        } else {
            //Query the local storage if available.
            tasksLocalDataSource.loadAllTasks(object : TasksDataSource.LoadAllTasksCallback {
                override fun onAllTasksLoaded(allTasks: List<Task>) {
                    refreshCache(allTasks)
                    callback.onAllTasksLoaded(allTasks)
                }

                override fun onAllTasksNotAvailable() {
                    //If not, query the network.
                    loadAllTasksFromRemoteSource(callback)
                }
            })
        }

    }

    private fun loadAllTasksFromRemoteSource(callback: TasksDataSource.LoadAllTasksCallback) {
        tasksRemoteDataSource.loadAllTasks(object : TasksDataSource.LoadAllTasksCallback {
            override fun onAllTasksLoaded(allTasks: List<Task>) {
                refreshCache(allTasks)
                refreshLocalDataLocalDataSource(allTasks)
                callback.onAllTasksLoaded(allTasks)
            }

            override fun onAllTasksNotAvailable() {
                callback.onAllTasksNotAvailable()
            }
        })
    }

    private fun refreshCache(tasks: List<Task>) {
        cacheTasks.clear()
        tasks.forEach { cacheTasks[it.id] = it }
        isCacheDirty = false
    }

    private fun refreshLocalDataLocalDataSource(tasks: List<Task>) {
        tasksLocalDataSource.deleteAllTasks()
        tasks.forEach { tasksLocalDataSource.saveTask(it) }
    }

    override fun saveTask(task: Task) {
        TODO("not implemented")
    }

    override fun deleteAllTasks() {
        TODO("not implemented")
    }

    override fun loadSingleTask(taskId: String, loadSingleTaskCallback: TasksDataSource.LoadSingleTaskCallback) {
        TODO("not implemented")
    }

    override fun refreshTasks() {
        isCacheDirty = true
    }

    companion object {
        private var INSTANCE: TasksRepository? = null

        @JvmStatic
        fun getInstance(tasksLocalDataSource: TasksLocalDataSource,
                        tasksRemoteDataSource: TasksRemoteDataSource) = INSTANCE
                ?: TasksRepository(tasksLocalDataSource, tasksRemoteDataSource).apply { INSTANCE = this }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }

}
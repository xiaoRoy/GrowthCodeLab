package com.learn.growthcodelab.architecture.mvp.tasks

import com.learn.growthcodelab.architecture.mvp.data.source.TasksRepository

class TasksPresenter constructor(private val tasksRepository: TasksRepository,
                     private val view: TasksContract.View) : TasksContract.Presenter {


    var isFirstLoad = true

    override fun start() {
    }
}
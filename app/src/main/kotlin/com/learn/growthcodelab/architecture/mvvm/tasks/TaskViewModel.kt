package com.learn.growthcodelab.architecture.mvvm.tasks

import android.content.Context
import android.databinding.BaseObservable
import com.learn.growthcodelab.architecture.data.source.TasksRepository

/*
* a view directly binds to properties on the view model to send and receive updates.
* https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel
* */
class TaskViewModel(val taskRepository: TasksRepository, context: Context) : BaseObservable() {

    private val context: Context = context.applicationContext



}
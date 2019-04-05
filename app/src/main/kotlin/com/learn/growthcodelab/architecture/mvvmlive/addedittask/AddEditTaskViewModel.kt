package com.learn.growthcodelab.architecture.mvvmlive.addedittask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.growthcodelab.architecture.data.Task
import com.learn.growthcodelab.architecture.data.source.TasksDataSource
import com.learn.growthcodelab.architecture.data.source.TasksRepository

class AddEditTaskViewModel(
        private val tasksRepository: TasksRepository
) : ViewModel(), TasksDataSource.LoadSingleTaskCallback {

    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    val isTaskLoading = MutableLiveData<Boolean>()

    private var taskId: String? = null

    private var isNewTask = false

    private var isTaskLoaded = false

    private var isTaskCompleted = false

    fun start(taskId: String?) {

        isTaskLoading.value?.let {
            if (!it) {
                return
            }
        }

        this.taskId = taskId
        if (taskId == null) {
            isNewTask = true
            return
        }

        if(isTaskLoaded) {
            return
        }

        isNewTask = false
        isTaskLoading.value = true

        tasksRepository.loadSingleTask(taskId, this)
    }

    override fun onSingleTaskLoaded(task: Task) {
        title.value = task.title
        description.value = task.description
        isTaskCompleted = task.isCompleted
        isTaskLoading.value = false
        isTaskLoaded = true
    }

    override fun onSingleTaskNotAvailable() {
        TODO("not implemented")
    }
}
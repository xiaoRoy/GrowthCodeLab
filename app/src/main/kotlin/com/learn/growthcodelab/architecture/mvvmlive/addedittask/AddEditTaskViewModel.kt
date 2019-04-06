package com.learn.growthcodelab.architecture.mvvmlive.addedittask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.growthcodelab.R
import com.learn.growthcodelab.architecture.data.Task
import com.learn.growthcodelab.architecture.data.source.TasksDataSource
import com.learn.growthcodelab.architecture.data.source.TasksRepository
import com.learn.growthcodelab.architecture.mvvmlive.Event

class AddEditTaskViewModel(
        private val tasksRepository: TasksRepository
) : ViewModel(), TasksDataSource.LoadSingleTaskCallback {

    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()


    // we just allow it to change in this view model instead of outside
    // so we change it to just live data.
    private val _isTaskLoading = MutableLiveData<Boolean>()
    val isTaskLoading: LiveData<Boolean>
        get() = _isTaskLoading

    private val _message = MutableLiveData<Event<Int>>()
    val message: LiveData<Event<Int>>
        get() = _message

    private val _taskUpdated = MutableLiveData<Event<Unit>>()
    val taskUpdated: LiveData<Event<Unit>>
        get() = _taskUpdated

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

        if (isTaskLoaded) {
            return
        }

        isNewTask = false
        _isTaskLoading.value = true
        tasksRepository.loadSingleTask(taskId, this)
    }

    override fun onSingleTaskLoaded(task: Task) {
        title.value = task.title
        description.value = task.description
        isTaskCompleted = task.isCompleted
        _isTaskLoading.value = false
        isTaskLoaded = true
    }

    override fun onSingleTaskNotAvailable() {
        _isTaskLoading.value = false
    }

    internal fun saveTask() {
        val currentTitle = title.value
        val currentDescription = description.value


        if (currentTitle == null || currentDescription == null) {
            _message.value = Event(R.string.empty_task_message)
            return
        }

        if (Task(currentDescription, currentTitle).isEmpty) {
            _message.value = Event(R.string.empty_task_message)
            return
        }

        val currentTaskId = taskId
        if (isNewTask || currentTaskId == null) {
            createTask(Task(currentDescription, currentTitle))
        } else{
            val task = Task(currentDescription, currentTitle, currentTaskId, isTaskCompleted)
            updateTask(task)
        }
    }

    private fun createTask(newTask: Task) {
        tasksRepository.saveTask(newTask)
        _taskUpdated.value = Event(Unit)
    }

    private fun updateTask(task: Task) {
        if(isNewTask) {
            throw RuntimeException("updateTask() was called but task is new.")
        }
        tasksRepository.saveTask(task)
        _taskUpdated.value = Event(Unit)
    }
}
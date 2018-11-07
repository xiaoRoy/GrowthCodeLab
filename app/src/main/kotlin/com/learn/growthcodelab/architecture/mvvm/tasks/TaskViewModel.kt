package com.learn.growthcodelab.architecture.mvvm.tasks

import android.content.Context
import android.databinding.*
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import com.learn.growthcodelab.BR
import com.learn.growthcodelab.R
import com.learn.growthcodelab.architecture.data.Task
import com.learn.growthcodelab.architecture.data.TasksFilterType
import com.learn.growthcodelab.architecture.data.source.TasksDataSource
import com.learn.growthcodelab.architecture.data.source.TasksRepository

/*
* a view directly binds to properties on the view model to send and receive updates.
* https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel
* */
class TaskViewModel(val tasksRepository: TasksRepository, context: Context) : BaseObservable() {

    private val context: Context

    private var currentFiltering: TasksFilterType

    val tasks: ObservableArrayList<Task> = ObservableArrayList()

    val currentFilteringLabel: ObservableField<String> = ObservableField()

    val noTasksLabel: ObservableField<String> = ObservableField()

    val noTaskIcon: ObservableField<Drawable> = ObservableField()

    val isDataLoading: ObservableBoolean = ObservableBoolean(false)

    val hasDataLoadingError: ObservableBoolean = ObservableBoolean(false)

    @get:Bindable
    var isEmpty: Boolean = tasks.isEmpty()


    init {
        this.context = context.applicationContext
        currentFiltering = TasksFilterType.ALL_TASKS
        setFiltering(TasksFilterType.ALL_TASKS)
    }

    fun loadTasks(forceUpdate: Boolean) {
        loadTasks(forceUpdate, showLoadingUI = true)
    }

    private fun loadTasks(forceUpdate: Boolean, showLoadingUI: Boolean) {
        if (showLoadingUI) {
            isDataLoading.set(showLoadingUI)
        }

        if (forceUpdate) {
            tasksRepository.refreshTasks()
        }

        tasksRepository.loadAllTasks(object : TasksDataSource.LoadAllTasksCallback {
            override fun onAllTasksLoaded(allTasks: List<Task>) {
                val tasksToShow = mutableListOf<Task>()
                allTasks.forEach {
                    when (currentFiltering) {
                        TasksFilterType.ALL_TASKS -> tasksToShow.add(it)
                        TasksFilterType.ACTIVE_TASKS -> {
                            if (it.isActive) {
                                tasksToShow.add(it)
                            }
                        }
                        TasksFilterType.COMPLETED_TASKS -> {
                            if (it.isCompleted) {
                                tasksToShow.add(it)
                            }
                        }
                    }
                }
                if(showLoadingUI){
                    isDataLoading.set(false)
                }
                hasDataLoadingError.set(false)
                tasks.clear()
                tasks.addAll(tasksToShow)
                notifyPropertyChanged(BR.isEmpty)
            }

            override fun onAllTasksNotAvailable() {
                hasDataLoadingError.set(true)
            }
        })

    }

    fun setFiltering(requestFilterType: TasksFilterType) {
        currentFiltering = requestFilterType
        var currentFilteringLabelRes = 0
        var noTasksLabelRes = 0
        var noTasksIconRes = 0
        when (requestFilterType) {
            TasksFilterType.ALL_TASKS -> {
                currentFilteringLabelRes = R.string.label_all
                noTasksLabelRes = R.string.no_tasks_all
                noTasksIconRes = R.drawable.ic_assignment_turned_in_24dp
            }
            TasksFilterType.ACTIVE_TASKS -> {
                currentFilteringLabelRes = R.string.label_active
                noTasksLabelRes = R.string.no_tasks_active
                noTasksIconRes = R.drawable.ic_check_circle_24dp
            }
            TasksFilterType.COMPLETED_TASKS -> {
                currentFilteringLabelRes = R.string.label_completed
                noTasksLabelRes = R.string.no_tasks_completed
                noTasksIconRes = R.drawable.ic_verified_user_24dp
            }
        }
        val resource = context.resources
        currentFilteringLabel.set(resource.getString(currentFilteringLabelRes))
        noTasksLabel.set(resource.getString(noTasksLabelRes))
        noTaskIcon.set(ContextCompat.getDrawable(context, noTasksIconRes))
    }


}
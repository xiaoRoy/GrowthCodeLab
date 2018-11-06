package com.learn.growthcodelab.architecture.mvp.tasks

import com.learn.growthcodelab.architecture.data.Task
import com.learn.growthcodelab.architecture.data.TasksFilterType
import com.learn.growthcodelab.architecture.data.source.TasksDataSource
import com.learn.growthcodelab.architecture.data.source.TasksRepository

class TasksPresenter constructor(tasksRepository: TasksRepository,
                                 view: TasksContract.View) : TasksContract.Presenter {

    private val tasksRepository: TasksRepository

    private val view: TasksContract.View

    var isFirstLoad: Boolean

    var currentFilterType: TasksFilterType

    init {
        this.tasksRepository = tasksRepository
        this.view = view
        view.setPresenter(this)
        isFirstLoad = true
        currentFilterType = TasksFilterType.ALL_TASKS
    }

    override fun start() {
        loadTasks(false)
    }

    override fun loadTasks(forceUpdate: Boolean) {
        loadTasks(forceUpdate || isFirstLoad, true)
        isFirstLoad = false
    }

    private fun loadTasks(forceUpdate: Boolean, showLoadingUI: Boolean) {

        if (showLoadingUI) {
            view.showLoadingIndicator(true)
        }

        if (forceUpdate) {
            tasksRepository.refreshTasks()
        }

        tasksRepository.loadAllTasks(object : TasksDataSource.LoadAllTasksCallback {
            override fun onAllTasksLoaded(allTasks: List<Task>) {
                val tasksToShow = mutableListOf<Task>()

                allTasks.forEach {
                    when (currentFilterType) {

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

                if (!view.isActive()) {
                    return
                }

                if (showLoadingUI) {
                    view.showLoadingIndicator(false)
                }

                processTasksToShow(tasksToShow)
            }

            override fun onAllTasksNotAvailable() {
                if (!view.isActive()) {
                    return
                }
                view.showLoadingTasksError()
            }
        })
    }

    private fun processTasksToShow(tasksToShow: List<Task>) {
        if (tasksToShow.isEmpty()) {
            processEmptyTasks()
        } else {
            view.showTasks(tasksToShow)
            showFilterLabel()
        }
    }

    private fun processEmptyTasks() {
        when (currentFilterType) {
            TasksFilterType.ACTIVE_TASKS -> view.showNoActiveTasks()
            TasksFilterType.COMPLETED_TASKS -> view.showNoCompletedTasks()
            TasksFilterType.ALL_TASKS -> view.showNoTasks()
        }
    }

    private fun showFilterLabel() {
        when (currentFilterType) {
            TasksFilterType.ACTIVE_TASKS -> view.showActiveFilterLabel()
            TasksFilterType.COMPLETED_TASKS -> view.showCompletedFilterLabel()
            TasksFilterType.ALL_TASKS -> view.showAllFilterLabel()
        }
    }
}
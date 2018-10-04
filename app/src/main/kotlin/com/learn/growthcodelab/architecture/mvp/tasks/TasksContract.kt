package com.learn.growthcodelab.architecture.mvp.tasks

import com.learn.growthcodelab.architecture.mvp.BasePresenter
import com.learn.growthcodelab.architecture.mvp.BaseView
import com.learn.growthcodelab.architecture.mvp.data.Task

interface TasksContract {

    interface Presenter : BasePresenter {
        fun loadTasks(forceUpdate: Boolean)
    }


    interface View : BaseView<Presenter> {

        fun showLoadingIndicator(isIndicatorVisible: Boolean)

        fun isActive(): Boolean

        fun showLoadingTasksError()

        fun showTasks(tasks: List<Task>)

        fun showNoActiveTasks()

        fun showNoCompletedTasks()

        fun showNoTasks()

        fun showActiveFilterLabel()

        fun showCompletedFilterLabel()

        fun showAllFilterLabel()

    }
}
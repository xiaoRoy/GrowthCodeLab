package com.learn.growthcodelab.architecture.mvp.tasks

import com.learn.growthcodelab.architecture.mvp.BasePresenter
import com.learn.growthcodelab.architecture.mvp.BaseView

interface TasksContract {

    interface Presenter : BasePresenter {

    }


    interface View : BaseView<Presenter> {

        fun loadTasks(forceUpdate: Boolean)
    }
}
package com.learn.growthcodelab.architecture.mvvmlive.addedittask

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity

class AddEditTaskActivity : BaseActivity(), AddEditTaskNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_task)
    }

    override fun obtainAddEditTaskViewModel()
            = ViewModelProviders.of(this).get(AddEditTaskViewModel::class.java)
}
package com.learn.growthcodelab.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class FlowStepFragment: BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_nav_flow_step_one
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
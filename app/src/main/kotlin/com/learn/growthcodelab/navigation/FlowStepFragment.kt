package com.learn.growthcodelab.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.NavArgsLazy
import androidx.navigation.fragment.navArgs
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class FlowStepFragment: BaseFragment() {

//    private val args: NavArgsLazy<FlowStepFragmentArgs> = navArgs()

    private var flowStep = STEP_ONE

    override fun getLayoutRes(): Int {
        return if(flowStep == STEP_TWO) R.layout.fragment_nav_flow_step_two
        else R.layout.fragment_nav_flow_step_one
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val safeArgs: FlowStepFragmentArgs by navArgs()
        flowStep = safeArgs.flowStep

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        const val STEP_ONE = 1
        const val STEP_TWO = 2
    }
}
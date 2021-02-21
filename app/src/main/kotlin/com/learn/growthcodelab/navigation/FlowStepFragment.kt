package com.learn.growthcodelab.navigation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.NavArgsLazy
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class FlowStepFragment : BaseFragment() {

//    private val args: NavArgsLazy<FlowStepFragmentArgs> = navArgs()

    private var flowStep = STEP_ONE

    override fun getLayoutRes(): Int {
        return if (flowStep == STEP_TWO) R.layout.fragment_nav_flow_step_two
        else R.layout.fragment_nav_flow_step_one
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val safeArgs: FlowStepFragmentArgs by navArgs()
        flowStep = safeArgs.flowStep

    }

    private fun getArgs() {
        arguments?.let {
            val safeArgs = FlowStepFragmentArgs.fromBundle(it)
            flowStep = safeArgs.flowStep
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //If we use the same action ID in different destination, you can navigate to
        //the destination depending on the context(which destination we define this action)
        /* view.findViewById<Button>(R.id.next_button).setOnClickListener(
                 Navigation.createNavigateOnClickListener(R.id.action_next)
         )*/
        //using different action id
        val actionId = if (flowStep == STEP_TWO) R.id.action_back_to_home else R.id.action_flow_step_two
        view.findViewById<Button>(R.id.next_button).setOnClickListener(
                Navigation.createNavigateOnClickListener(actionId)
        )
    }

    companion object {
        const val STEP_ONE = 1
        const val STEP_TWO = 2
    }
}
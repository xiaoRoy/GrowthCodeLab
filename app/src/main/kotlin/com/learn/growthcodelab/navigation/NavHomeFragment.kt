package com.learn.growthcodelab.navigation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment
import com.learn.growthcodelab.navigation.game.GameActivity

class NavHomeFragment : BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_nav_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navOptions = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        val args = FlowStepFragmentArgs.Builder().apply {
            flowStep = FlowStepFragment.STEP_ONE
        }.build().toBundle()
        view.findViewById<Button>(R.id.navigate_destination_button).setOnClickListener {
            findNavController().navigate(R.id.destination_nav_step_one, args, navOptions)
        }


        /* view.findViewById<Button>(R.id.navigate_action_button).setOnClickListener(
                 Navigation.createNavigateOnClickListener(R.id.action_flow_step_one, null)
         )*/

        view.findViewById<Button>(R.id.navigate_action_button).setOnClickListener {
            findNavController().navigate(NavHomeFragmentDirections.actionFlowStepOne())
        }

        view.findViewById<Button>(R.id.btn_to_game).setOnClickListener {
            findNavController().navigate(NavHomeFragmentDirections.actionGame())
        }
    }
}
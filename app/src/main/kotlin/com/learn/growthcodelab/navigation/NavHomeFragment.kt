package com.learn.growthcodelab.navigation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class NavHomeFragment : BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_nav_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.navigate_destination_button).setOnClickListener {
            findNavController().navigate(R.id.action_flow_step_one)
        }

    }
}
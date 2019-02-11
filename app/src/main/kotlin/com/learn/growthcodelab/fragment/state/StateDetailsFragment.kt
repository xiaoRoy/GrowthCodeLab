package com.learn.growthcodelab.fragment.state

import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class StateDetailsFragment : BaseFragment(){

    companion object {
        fun newInstance() = StateDetailsFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_state_details
}
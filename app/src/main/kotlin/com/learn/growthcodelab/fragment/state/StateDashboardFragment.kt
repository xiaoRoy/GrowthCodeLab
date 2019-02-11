package com.learn.growthcodelab.fragment.state

import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class StateDashboardFragment : BaseFragment(), PopBackListener{

    companion object {
        fun newInstance() = StateDashboardFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_state_dashboard

    override fun enableLifeCycleLog(): Boolean {
        return true
    }
}
package com.learn.growthcodelab.fragment.state

import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class SectionAFragment : BaseFragment() {

    companion object {
        fun newInstance() = SectionAFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_section_a

    override fun enableLifeCycleLog(): Boolean {
        return false
    }
}
package com.learn.growthcodelab.fragment.state

import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class SectionBFragment : BaseFragment(){

    companion object {
       fun newInstance() = SectionBFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_section_b
}
package com.learn.growthcodelab.playground

import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class OverdrawFragment : BaseFragment() {

    companion object {
        fun newInstance() = OverdrawFragment()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_over_draw
    }
}
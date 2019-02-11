package com.learn.growthcodelab.fragment.state

import android.support.v4.app.Fragment
import com.learn.growthcodelab.fragment.BaseFragment

abstract class BaseSectionFragment : BaseFragment(){

    protected val fragmentSates: MutableList<Fragment.SavedState> = mutableListOf()

}
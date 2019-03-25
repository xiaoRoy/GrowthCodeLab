package com.learn.growthcodelab.fragment.state

import androidx.fragment.app.Fragment
import com.learn.growthcodelab.fragment.BaseFragment

abstract class BaseSectionFragment : BaseFragment(){

    protected val fragmentSates: MutableList<androidx.fragment.app.Fragment.SavedState> = mutableListOf()

}
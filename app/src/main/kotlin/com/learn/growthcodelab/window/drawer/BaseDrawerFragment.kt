package com.learn.growthcodelab.window.drawer

import android.content.Context
import com.learn.growthcodelab.fragment.BaseFragment
import java.lang.IllegalArgumentException

abstract class BaseDrawerFragment : BaseFragment(){

    protected lateinit var navigator: DrawerNavigator

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        navigator = if (context is DrawerNavigator) context else throw IllegalArgumentException()
    }
}
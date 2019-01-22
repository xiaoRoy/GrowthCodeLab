package com.learn.growthcodelab.fragment

import android.content.Context
import java.lang.IllegalStateException


abstract class PlayGroundAbstractFragment : BaseFragment() {

    protected lateinit var navigator: FragmentPlayGroundNavigator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator = try {
            context as FragmentPlayGroundNavigator
        } catch (exception : ClassCastException) {
            throw IllegalStateException("Host Activity must implement FragmentPlayGroundNavigator")
        }

    }

}
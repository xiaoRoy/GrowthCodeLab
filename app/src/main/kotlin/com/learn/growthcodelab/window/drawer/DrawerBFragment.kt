package com.learn.growthcodelab.window.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentDrawerBBinding

class DrawerBFragment : BaseDrawerFragment() {

    private lateinit var binding: FragmentDrawerBBinding

    companion object {
        fun newInstance() = DrawerBFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_drawer_b

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.navigator = navigator
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        ViewCompat.requestApplyInsets(view)
    }
}
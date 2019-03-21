package com.learn.growthcodelab.window.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentDrawerABinding
import com.learn.growthcodelab.fragment.BaseFragment

class DrawerAFragment : BaseDrawerFragment() {

    companion object {
        fun newInstance() = DrawerAFragment()
    }

    private lateinit var binding: FragmentDrawerABinding



    override fun getLayoutRes(): Int {
        return R.layout.fragment_drawer_a
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.navigator = navigator
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
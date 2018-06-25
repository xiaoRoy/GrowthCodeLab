package com.learn.growthcodelab.databinding.layout

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentRegistryTrackingBinding
import com.learn.growthcodelab.fragment.BaseFragment

class RegistryTrackingFragment : BaseFragment(){

    companion object {
        fun newInstance() = RegistryTrackingFragment ()
    }

    override fun getLayoutRes() = R.layout.fragment_registry_tracking

    override fun bindView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = DataBindingUtil.inflate<FragmentRegistryTrackingBinding>(inflater, layoutRes, container,false)
        return binding.root
    }
}
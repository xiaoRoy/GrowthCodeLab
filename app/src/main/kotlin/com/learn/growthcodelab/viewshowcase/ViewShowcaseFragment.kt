package com.learn.growthcodelab.viewshowcase

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentViewShowcaseBinding
import com.learn.growthcodelab.fragment.BaseFragment

class ViewShowcaseFragment : BaseFragment(){

    companion object {
        fun newInstance() = ViewShowcaseFragment()
    }


    override fun getLayoutRes() = R.layout.fragment_view_showcase

    override fun bindView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = DataBindingUtil.inflate<FragmentViewShowcaseBinding>(inflater, layoutRes, container, false)
        return binding.root
    }
}
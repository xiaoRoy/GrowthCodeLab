package com.learn.growthcodelab.viewshowcase.viewpager.lifecycle

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentLifecycleInViewPagerBinding
import com.learn.growthcodelab.fragment.BaseFragment

class LifeCycleInViewPageFragment : BaseFragment(){

    private lateinit var pagerAdapter: LifeCycleInViewPagerFragmentStateAdapter
    private lateinit var binding: FragmentLifecycleInViewPagerBinding

    override fun getLayoutRes() = R.layout.fragment_lifecycle_in_view_pager

    override fun bindView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate<FragmentLifecycleInViewPagerBinding>(inflater, layoutRes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagerAdapter = LifeCycleInViewPagerFragmentStateAdapter(childFragmentManager, LikeItem.generateLikeItems())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewPagerLifecycle.adapter = pagerAdapter
    }

    companion object {
        fun newInstance() = LifeCycleInViewPageFragment()
    }
}
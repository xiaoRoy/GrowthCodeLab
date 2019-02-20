package com.learn.growthcodelab.viewshowcase.viewpager.lifecycle

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentLifecycleInViewPagerBinding
import com.learn.growthcodelab.fragment.BaseFragment

class LifeCycleInViewPageFragment : BaseFragment(),
        LikeItemLifeCycleCallback, View.OnClickListener{


    private lateinit var pagerAdapter: LifeCycleInViewPagerFragmentStateAdapter
    private lateinit var binding: FragmentLifecycleInViewPagerBinding

    override fun getLayoutRes() = R.layout.fragment_lifecycle_in_view_pager

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagerAdapter = LifeCycleInViewPagerFragmentStateAdapter(childFragmentManager, LikeItem.generateLikeItems())
        binding.listener = this

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewPagerLifecycle.adapter = pagerAdapter
    }

    override fun onAttachFragment(childFragment: androidx.fragment.app.Fragment) {
        (childFragment as LifeCycleInViewPageItemFragment).callback = this
    }

    override fun onClick(view: View) {
        updateLikeAmount()
    }

    private fun updateLikeAmount() {
         val itemFragment = pagerAdapter.getItemByPosition(binding.viewPagerLifecycle.currentItem)
        if(itemFragment.isAdded) {
            itemFragment.updateLikeAmount()
        }
    }

    override fun showTip() {
        val itemFragment = pagerAdapter.getItemByPosition(binding.viewPagerLifecycle.currentItem)
        if(itemFragment.isAdded) {
            itemFragment.showTip(true)
        }
    }

    companion object {
        fun newInstance() = LifeCycleInViewPageFragment()
    }
}
package com.learn.growthcodelab.viewshowcase.viewpager.lifecycle

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class LifeCycleInViewPagerFragmentStateAdapter(
        fragmentManager: FragmentManager,
        private val likeItems: List<LikeItem>
): FragmentStatePagerAdapter(fragmentManager){

    private val items: List<LifeCycleInViewPageItemFragment> = likeItems.map {
        LifeCycleInViewPageItemFragment.newInstance(it)
    }

    override fun getItem(position: Int) = items[position]

    override fun getCount() = items.size
}
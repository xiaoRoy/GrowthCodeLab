package com.learn.growthcodelab.viewshowcase.viewpager.lifecycle

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log
import android.view.ViewGroup

class LifeCycleInViewPagerFragmentStateAdapter(
        fragmentManager: FragmentManager,
        private val likeItems: List<LikeItem>
): FragmentStatePagerAdapter(fragmentManager){

    private val items: List<LifeCycleInViewPageItemFragment> = likeItems.map {
        LifeCycleInViewPageItemFragment.newInstance(it)
    }

    override fun getItem(position: Int) = items[position]

    override fun getCount() = items.size

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        Log.d("trail", "instantiateItem:position:$position")
        return super.instantiateItem(container, position)
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        Log.d("trail", "destroyItem:position:$position")
        super.destroyItem(container, position, `object`)
    }

    override fun getItemPosition(`object`: Any?): Int {
        return super.getItemPosition(`object`)
    }

    fun getItemByPosition(position: Int) = items[position]
}
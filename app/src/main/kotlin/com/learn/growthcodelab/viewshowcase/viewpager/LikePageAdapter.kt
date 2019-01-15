package com.learn.growthcodelab.viewshowcase.viewpager

import android.databinding.DataBindingUtil
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.LayoutViewPagerItemLikeBinding

class LikePageAdapter(
        private val likeList: MutableList<Int>
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = DataBindingUtil.inflate<LayoutViewPagerItemLikeBinding>(
                LayoutInflater.from(container.context),
                R.layout.layout_view_pager_item_like,
                container,
                false)
        binding.count = likeList[position]
        val itemView = binding.root
        container.addView(itemView)
        return itemView
    }

    override fun isViewFromObject(view: View?, `object`: Any?) = (view === `object`)

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
        container.removeView(`object` as View)
    }

    override fun getCount() = likeList.size
}
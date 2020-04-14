package com.learn.growthcodelab.viewshowcase.viewpager2

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CategoryFragmentStateAdapter(
        private val categoryTabList: List<CategoryTab>,
        parentFragment: Fragment
) : FragmentStateAdapter(parentFragment) {

    override fun getItemCount(): Int {
        return categoryTabList.size
    }

    override fun createFragment(position: Int): Fragment {
        val categoryTab = categoryTabList[position]
        return CategoryTabFragment.newInstance(categoryTab)
    }
}
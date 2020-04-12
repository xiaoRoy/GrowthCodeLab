package com.learn.growthcodelab.viewshowcase.viewpager2

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentCategoryBinding
import com.learn.growthcodelab.fragment.BaseFragment

class CategoryFragment : BaseFragment() {

    private lateinit var binding: FragmentCategoryBinding

    private lateinit var categoryAdapter: CategoryFragmentStateAdapter

    override fun getLayoutRes(): Int {
        return R.layout.fragment_category
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
       return DataBindingUtil.inflate<FragmentCategoryBinding>(inflater, layoutRes, container, false)
               .also { binding = it }
               .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryTabs = CategoryTab.createCategoryTab()
        categoryAdapter = CategoryFragmentStateAdapter(categoryTabs, this)
        binding.viewPagerCategory.adapter = categoryAdapter
        with(binding) {
            TabLayoutMediator(tabLayoutCategory, viewPagerCategory) { tab, position ->
                tab.text = categoryTabs[position].tabName
            }.attach()
        }

    }

    companion object {
        fun newInstance() = CategoryFragment()
    }

}

class CategoryTab(
        val tabName: String,
        @ColorRes val backgroundColor: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString() ?: "",
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tabName)
        parcel.writeInt(backgroundColor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CategoryTab> {
        override fun createFromParcel(parcel: Parcel): CategoryTab {
            return CategoryTab(parcel)
        }

        override fun newArray(size: Int): Array<CategoryTab?> {
            return arrayOfNulls(size)
        }

        fun createCategoryTab(): List<CategoryTab> {
            return listOf(CategoryTab("Sport", android.R.color.holo_blue_light),
                    CategoryTab("Music", android.R.color.holo_green_light),
                    CategoryTab("News", android.R.color.holo_red_light),
                    CategoryTab("Technology", android.R.color.holo_orange_light))

        }
    }

}
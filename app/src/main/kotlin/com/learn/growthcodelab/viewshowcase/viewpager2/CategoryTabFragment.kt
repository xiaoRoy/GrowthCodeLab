package com.learn.growthcodelab.viewshowcase.viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentCategoryBinding
import com.learn.growthcodelab.databinding.FragmentCategoryTabBinding
import com.learn.growthcodelab.fragment.BaseFragment

class CategoryTabFragment : BaseFragment() {

    private lateinit var categoryTab: CategoryTab

    override fun enableLifeCycleLog(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryTab = arguments?.getParcelable(BUNDLE_KEY_CATEGORY_TAB) ?: throw IllegalArgumentException()
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return DataBindingUtil.inflate<FragmentCategoryTabBinding>(layoutInflater, layoutRes, container, false)
                .apply {
                    categoryTab = this@CategoryTabFragment.categoryTab
                }.root
    }



    override fun getLayoutRes(): Int {
        return R.layout.fragment_category_tab
    }

    companion object {
        private const val BUNDLE_KEY_CATEGORY_TAB = "bundle_key_category_tab"

        fun newInstance(categoryTab: CategoryTab): CategoryTabFragment {
            return CategoryTabFragment().apply {
                arguments = Bundle(1).apply {
                    putParcelable(BUNDLE_KEY_CATEGORY_TAB, categoryTab)
                }
            }
        }
    }

}
package com.learn.growthcodelab.recycler.group.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentCategoriesBinding
import com.learn.growthcodelab.fragment.BaseFragment
import com.learn.growthcodelab.recycler.group.GroupAdapter

class CategoriesFragment : BaseFragment() {

    private lateinit var binding: FragmentCategoriesBinding

    override fun getLayoutRes() = R.layout.fragment_categories
    private val groupAdapter = GroupAdapter()

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return DataBindingUtil.inflate<FragmentCategoriesBinding>(inflater, layoutRes, container, false)
                .also { binding = it }
                .root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setup()
    }

    private fun setup() {
        val categories = generateCategories()
        categories.map {
            val subCategoryGroup = SubCategoryGroup(CategoryExpandableHeader(it))
            it.subCategories.forEach { subcategory ->
                subCategoryGroup.addChild(SubCategoryItem(subcategory))
            }
            subCategoryGroup
        }.let { groupAdapter.groups.addAll(it) }
        groupAdapter.spanCount = 6
        val gridLayoutManager = GridLayoutManager(binding.recyclerCategories.context, groupAdapter.spanCount)
        gridLayoutManager.spanSizeLookup = groupAdapter.spanSizeLookup
        binding.recyclerCategories.layoutManager = gridLayoutManager
        binding.recyclerCategories.adapter = groupAdapter
    }

    companion object {
        fun newInstance() = CategoriesFragment()
    }
}
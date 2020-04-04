package com.learn.growthcodelab.recycler.group.sample

import com.learn.growthcodelab.BR
import com.learn.growthcodelab.R
import com.learn.growthcodelab.recycler.DataBindingViewHolder
import com.learn.growthcodelab.recycler.group.BaseGroup
import com.learn.growthcodelab.recycler.group.BaseViewType

class SubCategoryItem(private val subCategory: SubCategory): BaseGroup {

    override fun getViewType(position: Int): BaseViewType {
        return SubCategoryChildViewType(subCategory)
    }

    override fun getItemCount(): Int {
        return 1
    }
}

class SubCategoryChildViewType(private val subCategory: SubCategory) : BaseViewType() {
    override fun onBindViewHolder(viewHolder: DataBindingViewHolder, position: Int) {
        viewHolder.binding.setVariable(BR.subCategory, subCategory)
    }

    override fun getSpanCount(totalSpanCount: Int, position: Int): Int {
        return 2
    }

    override fun getLayoutResource(): Int {
        return R.layout.item_sub_category
    }
}
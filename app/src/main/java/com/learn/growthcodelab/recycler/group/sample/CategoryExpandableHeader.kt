package com.learn.growthcodelab.recycler.group.sample

import com.learn.growthcodelab.BR
import com.learn.growthcodelab.R
import com.learn.growthcodelab.recycler.DataBindingViewHolder
import com.learn.growthcodelab.recycler.group.BaseViewType
import com.learn.growthcodelab.recycler.group.ExpandableHeader

class CategoryExpandableHeader(private val category: Category) : ExpandableHeader() {

    override fun getViewType(position: Int): BaseViewType {
        return CategoryHeaderViewType(category)
    }

}

class CategoryHeaderViewType(private val category: Category) : BaseViewType() {
    override fun onBindViewHolder(viewHolder: DataBindingViewHolder, position: Int) {
        viewHolder.binding.setVariable(BR.category, category)
    }

    override fun getSpanCount(totalSpanCount: Int, position: Int): Int {
        return totalSpanCount / 2
    }

    override fun getLayoutResource(): Int {
        return R.layout.item_category_header
    }
}
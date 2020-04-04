package com.learn.growthcodelab.recycler.group.sample

import com.learn.growthcodelab.recycler.group.BaseViewType
import com.learn.growthcodelab.recycler.group.ExpandableGroup

class SubCategoryGroup(
        parent: CategoryExpandableHeader) : ExpandableGroup(parent
) {

    override fun getChildrenViewType(position: Int): BaseViewType {
        return children[position - 1].getViewType(position - 1)
    }
}


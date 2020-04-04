package com.learn.growthcodelab.recycler.group

interface GroupObserver {
    fun onChanged(group: BaseGroup)

    fun onItemRangeRemoved(group: BaseGroup, startPosition: Int, itemCount: Int)

    fun onItemRangeInserted(group: BaseGroup, startPosition: Int, itemCount: Int)
}
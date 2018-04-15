package com.learn.growthcodelab.recycler.expandable

interface GroupDataObserver {

    fun onChanged(group: BaseGroup)

    fun onItemInserted(group: BaseGroup, position: Int, payload: Any? = null)

    fun onItemChanged(group: BaseGroup, position: Int, payload: Any? = null)

    fun onItemRemoved(group: BaseGroup, position: Int)

    fun onItemRangeChanged(group: BaseGroup, positionStart: Int, itemCount: Int, payload: Any? = null)

    fun onItemRangeInserted(group: BaseGroup, positionStart: Int, itemCount: Int)

    fun onItemRangeRemoved(group: BaseGroup, positionStart: Int, itemCount: Int)

    fun onItemMoved(group: BaseGroup, fromPosition: Int, toPosition: Int)
}
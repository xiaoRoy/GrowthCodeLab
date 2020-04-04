package com.learn.growthcodelab.recycler.group

interface BaseGroup {

    fun getViewType(position: Int): BaseViewType

    fun getItemCount(): Int
}

abstract class ExpandableHeader : BaseGroup {

    override fun getItemCount(): Int {
        return 1
    }
}

abstract class ExpandableGroup(private val parent: ExpandableHeader) : BaseGroup {
    private val groupObservable = GroupObservable()
    protected val children = mutableListOf<BaseGroup>()
    private var isExpanded = true

    //position in group
    override fun getViewType(position: Int): BaseViewType {
        return if (position == 0) parent.getViewType(position) else getChildrenViewType(position)
    }

    abstract fun getChildrenViewType(position: Int): BaseViewType

    override fun getItemCount(): Int {
        val parentItemCount = parent.getItemCount()
        return if (isExpanded) parentItemCount + children.size else parentItemCount
    }

    fun notifyGroupChanged() {
        groupObservable.notifyGroupChanged(this)
    }

    fun notifyItemRangeInserted(startPosition: Int, itemCount: Int) {
        groupObservable.notifyItemRangeInserted(this, startPosition, itemCount)
    }

    fun notifyItemRangeRemoved(startPosition: Int, itemCount: Int) {
        groupObservable.notifyItemRangeRemoved(this, startPosition, itemCount)
    }

    fun addChild(group: BaseGroup) {
        children.add(group)
    }
}
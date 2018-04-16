package com.learn.growthcodelab.recycler.expandable

abstract class Group : BaseGroup, GroupDataObserver {

    val groupDataObservable = GroupDataObservable()

    override fun getItemCount(): Int {
        var count = 0
        for (index in 0..getGroupCount()) {
            val baseGroup = getGroup(index)
            count += baseGroup.getItemCount()
        }
        return count
    }

    protected fun <T : BaseGroup> getItemCount(groups: Collection<T>): Int {
        return groups.map { it.getItemCount() }.sum()
    }

    abstract fun getGroup(position: Int): BaseGroup

    abstract fun getGroupCount(): Int

    class GroupDataObservable {

    }
}
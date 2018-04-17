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
    /*
    * get item count before group with given group index
    * */
    protected fun getItemCount(groupIndex: Int): Int{
        var count = 0
        for(index in 0..groupIndex){
            val baseGroup = getGroup(index)
            count += baseGroup.getItemCount()
        }
        return count
    }

    protected fun getItemCount(baseGroup: BaseGroup): Int{
        val groupIndex = getGroupPosition(baseGroup)
        return getItemCount(groupIndex)
    }

    /*
    * Get the position of a ViewType
    * */
    final override fun getGroupPosition(viewType: BaseViewType<*>): Int{
        var previousPosition = 0
        var groupPosition = -1
        for(index in 0..getGroupCount()){
            val group = getGroup(index)
            val position = group.getGroupPosition(viewType)
            if(position >= 0){
                groupPosition = position + previousPosition
            }
            previousPosition += group.getItemCount()
        }
        return groupPosition
    }

    override fun getViewType(position: Int): BaseViewType<*> {
        var previousPosition = 0
        var viewType: BaseViewType<*>? = null
        for(index in 0..getGroupCount()){
            val group = getGroup(index)
            val groupSize = group.getItemCount()
            if(groupSize + previousPosition > position){
                viewType = group.getViewType(position - previousPosition)
            }
            previousPosition += groupSize
        }
        return viewType ?: throw IndexOutOfBoundsException()
    }

    abstract fun getGroup(position: Int): BaseGroup

    abstract fun getGroupCount(): Int

    abstract fun getGroupPosition(group: BaseGroup): Int

    class GroupDataObservable {

    }
}
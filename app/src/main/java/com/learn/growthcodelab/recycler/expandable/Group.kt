package com.learn.growthcodelab.recycler.expandable

import android.support.annotation.CallSuper

abstract class Group : BaseGroup, GroupDataObserver {

    private val groupDataObservable = GroupDataObservable()

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

    /*
    * get item count before the given group
    * */
    protected fun getItemCount(baseGroup: BaseGroup): Int{
        val groupIndex = getGroupPosition(baseGroup)
        return getItemCount(groupIndex)
    }

    /*
    * Get the (first?) position of a ViewType
    * */
    final override fun getGroupPosition(viewType: BaseViewType<*>): Int{
        var previousPosition = 0
        var groupPosition = -1
        for(index in 0..getGroupCount()){
            val group = getGroup(index)
            val position = group.getGroupPosition(viewType)
            if(position >= 0){
                groupPosition = position + previousPosition
                break
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
                break
            }
            previousPosition += groupSize
        }
        return viewType ?: throw IndexOutOfBoundsException()
    }

    override fun registerGroupDataObserver(groupDataObserver: GroupDataObserver) {
        groupDataObservable.registerObserver(groupDataObserver)
    }

    override fun unregisterGroupDataObserver(groupDataObserver: GroupDataObserver) {
        groupDataObservable.unregisterObserver(groupDataObserver)
    }

    @CallSuper open fun addGroup(position: Int = -1, baseGroup: BaseGroup){
        baseGroup.registerGroupDataObserver(this)
    }

    @CallSuper open fun <T: BaseGroup> addAllGroups(position: Int = -1, groups: Collection<T>){
        groups.forEach { it.registerGroupDataObserver(this) }
    }

    @CallSuper open fun removeGroup(group: BaseGroup){
        group.unregisterGroupDataObserver(this)
    }

    @CallSuper open fun <T: BaseGroup> removeAllGroups(groups: Collection<T>){
        groups.forEach { it.unregisterGroupDataObserver(this) }
    }



    abstract fun getGroup(position: Int): BaseGroup

    abstract fun getGroupCount(): Int

    abstract fun getGroupPosition(group: BaseGroup): Int


    class GroupDataObservable {

        private val observers: ArrayList<GroupDataObserver> = ArrayList()

        fun onGroupChanged(baseGroup: BaseGroup, position: Int, payload: Any? = null){
            observers.reversed().forEach{it.onItemChanged(baseGroup, position, payload)}
        }

        fun onGroupRangeChanged(group: BaseGroup, positionStar: Int, groupCount: Int, payload: Any? = null){
            observers.reversed().forEach{it.onItemRangeChanged(group, positionStar, groupCount, payload)}
        }

        fun onGroupInserted(group: BaseGroup, position: Int){
            observers.reversed().forEach{it.onItemInserted(group, position)}
        }

        fun onGroupRangeInserted(group: BaseGroup, positionStar: Int, groupCount: Int){
            observers.reversed().forEach{it.onItemRangeInserted(group, positionStar, groupCount)}
        }

        fun onGroupRemoved(baseGroup: BaseGroup, position: Int){
            observers.reversed().forEach{it.onItemRemoved(baseGroup, position)}
        }

        fun onGroupRangeRemoved(group: BaseGroup, positionStar: Int, groupCount: Int){
            observers.reversed().forEach{it.onItemRangeRemoved(group, positionStar, groupCount)}
        }

        fun onGroupMoved(){

        }


        fun registerObserver(groupDataObserver: GroupDataObserver){
            synchronized(observers){
                if(observers.contains(groupDataObserver)){
                    throw IllegalStateException("$groupDataObserver is already registered.")
                }
                observers.add(groupDataObserver)
            }
        }

        fun unregisterObserver(groupDataObserver: GroupDataObserver){
            synchronized(observers){
                val index = observers.indexOf(groupDataObserver)
                observers.removeAt(index)
            }
        }
    }
}
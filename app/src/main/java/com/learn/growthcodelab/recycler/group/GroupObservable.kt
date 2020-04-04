package com.learn.growthcodelab.recycler.group

class GroupObservable {

    private val observers: MutableList<GroupObserver> = mutableListOf()

    fun addObserver(groupObserver: GroupObserver) {
        if(groupObserver !in observers) {
            observers.add(groupObserver)
        }
    }

    fun removeObserver(groupObserver: GroupObserver) {
        if(groupObserver in observers) {
            observers.remove(groupObserver)
        }
    }

    fun notifyGroupChanged(group: BaseGroup) {
        observers.forEach {
            it.onChanged(group)
        }
    }

    fun notifyItemRangeInserted(group: BaseGroup, startPosition: Int, itemCount: Int) {
        observers.forEach {
            it.onItemRangeInserted(group, startPosition, itemCount)
        }
    }

    fun notifyItemRangeRemoved(group: BaseGroup, startPosition: Int, itemCount: Int) {
        observers.forEach {
            it.onItemRangeRemoved(group, startPosition, itemCount)
        }
    }
}
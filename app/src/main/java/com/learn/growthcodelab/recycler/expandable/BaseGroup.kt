package com.learn.growthcodelab.recycler.expandable

interface BaseGroup {
    fun getItemCount(): Int

    fun getItem(position: Int): BaseItem<*>

    fun getItemPosition(item: BaseItem<*>): Int

    fun registerGroupDataObserver(groupDataObserver: GroupDataObserver)

    fun unregisterGroupDataObserver(groupDataObserver: GroupDataObserver)
}
package com.learn.growthcodelab.recycler.expandable

interface BaseGroup {
    fun getItemCount(): Int

    fun getViewType(position: Int): BaseViewType<*>

    fun getPosition(viewType: BaseViewType<*>): Int
}
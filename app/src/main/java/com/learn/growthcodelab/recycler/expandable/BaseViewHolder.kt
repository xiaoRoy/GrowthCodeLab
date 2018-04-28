package com.learn.growthcodelab.recycler.expandable

import android.support.v7.widget.RecyclerView
import android.view.View

open class BaseViewHolder constructor(private val item: View) : RecyclerView.ViewHolder(item) {
    private var Item: BaseItem<*>? = null

    fun bind(item: BaseItem<*>){
        this.Item = item
    }

    fun unbind(){
        this.Item = null
    }
}
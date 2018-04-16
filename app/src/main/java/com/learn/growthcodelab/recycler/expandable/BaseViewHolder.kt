package com.learn.growthcodelab.recycler.expandable

import android.support.v7.widget.RecyclerView
import android.view.View

open class BaseViewHolder constructor(private val item: View) : RecyclerView.ViewHolder(item) {
    private var viewType: BaseViewType<*>? = null

    fun bind(viewType: BaseViewType<*>){
        this.viewType = viewType
    }

    fun unbind(){
        this.viewType = null
    }
}
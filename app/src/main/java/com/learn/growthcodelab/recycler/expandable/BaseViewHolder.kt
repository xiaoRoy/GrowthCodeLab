package com.learn.growthcodelab.recycler.expandable

import androidx.recyclerview.widget.RecyclerView
import android.view.View

open class BaseViewHolder constructor(private val item: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(item) {
    private var Item: BaseItem<*>? = null

    fun bind(item: BaseItem<*>){
        this.Item = item
    }

    fun unbind(){
        this.Item = null
    }
}
package com.learn.growthcodelab.recycler.group

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.learn.growthcodelab.recycler.DataBindingViewHolder

abstract class BaseViewType {

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        return parent.context.run {
            val layoutInflater = LayoutInflater.from(this)
            val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
            DataBindingViewHolder(binding)
        }
    }

    abstract fun onBindViewHolder(viewHolder: DataBindingViewHolder, position: Int)

    fun onBindViewHolder(viewHolder: DataBindingViewHolder, position: Int, payload: List<Any>) {
        onBindViewHolder(viewHolder, position)
    }

    abstract fun getLayoutResource(): Int

    abstract fun getSpanCount(totalSpanCount: Int, position: Int): Int

}

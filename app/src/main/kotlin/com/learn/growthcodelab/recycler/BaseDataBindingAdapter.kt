package com.learn.growthcodelab.recycler

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseDataBindingAdapter : RecyclerView.Adapter<DataBindingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DataBindingViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val viewDataBinding = DataBindingUtil
                .inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return DataBindingViewHolder(viewDataBinding)
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder?, position: Int) {
        holder?.bind(getItemByPosition(position))
    }

    override fun getItemViewType(position: Int) = getLayoutIdByPosition(position)

    protected abstract fun getItemByPosition(position: Int): Any

    protected abstract fun getLayoutIdByPosition(position: Int): Int
}
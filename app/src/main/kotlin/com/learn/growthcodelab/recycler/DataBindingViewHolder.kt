package com.learn.growthcodelab.recycler

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.learn.growthcodelab.BR

class DataBindingViewHolder(val binding: ViewDataBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

    fun bind(item : Any){
        binding.setVariable(BR.item, item)
        binding.setVariable(BR.position, adapterPosition)
        binding.executePendingBindings()
    }
}
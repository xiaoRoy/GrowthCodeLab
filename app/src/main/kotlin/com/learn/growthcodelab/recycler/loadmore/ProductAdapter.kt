package com.learn.growthcodelab.recycler.loadmore

import android.view.animation.AnimationUtils
import androidx.core.view.ViewCompat
import com.learn.growthcodelab.R
import com.learn.growthcodelab.recycler.BaseDataBindingAdapter
import com.learn.growthcodelab.recycler.DataBindingViewHolder

class ProductAdapter(private val products: MutableList<Product>) : BaseDataBindingAdapter(){

    private var lastPosition = -1

    override fun getItemByPosition(position: Int) = products[position]

    override fun getLayoutIdByPosition(position: Int) = R.layout.item_product

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        if (position > lastPosition) {
            val itemView = holder.itemView
            val animation = AnimationUtils.loadAnimation(itemView.context, R.anim.anim_bottom_in)
            itemView.startAnimation(animation)
            lastPosition = position
        }
    }

    override fun onViewDetachedFromWindow(holder: DataBindingViewHolder) {
        ViewCompat.animate(holder.itemView).cancel()
        super.onViewDetachedFromWindow(holder)
    }
}
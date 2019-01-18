package com.learn.growthcodelab.recycler.loadmore

import com.learn.growthcodelab.R
import com.learn.growthcodelab.recycler.BaseDataBindingAdapter

class ProductAdapter(private val products: MutableList<Product>) : BaseDataBindingAdapter(){

    override fun getItemByPosition(position: Int) = products[position]

    override fun getLayoutIdByPosition(position: Int) = R.layout.item_product

    override fun getItemCount() = products.size
}
package com.learn.growthcodelab.rx.cheese

import com.learn.growthcodelab.R
import com.learn.growthcodelab.recycler.BaseDataBindingAdapter

class CheesesAdapter : BaseDataBindingAdapter() {

    private val cheeseList = mutableListOf<Cheese>()

    override fun getItemByPosition(position: Int): Any = cheeseList[position]

    override fun getLayoutIdByPosition(position: Int): Int = R.layout.item_cheese

    override fun getItemCount(): Int = cheeseList.size

    fun updateCheese(cheeses: List<Cheese>) {
        cheeseList.clear()
        cheeseList.addAll(cheeses)
        notifyDataSetChanged()
    }
}
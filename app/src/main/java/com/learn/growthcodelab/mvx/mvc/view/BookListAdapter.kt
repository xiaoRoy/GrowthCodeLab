package com.learn.growthcodelab.mvx.mvc.view

import com.learn.growthcodelab.R
import com.learn.growthcodelab.mvx.mvc.model.bean.Book
import com.learn.growthcodelab.recycler.BaseDataBindingAdapter

class BookListAdapter(private val bookList: List<Book>): BaseDataBindingAdapter() {

    override fun getItemByPosition(position: Int): Book {
        return bookList[position]
    }

    override fun getLayoutIdByPosition(position: Int): Int {
        return R.layout.item_book
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}
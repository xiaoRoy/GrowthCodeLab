package com.learn.growthcodelab.mvx.mvc.view

import android.app.Activity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.ActivityBookListBinding
import com.learn.growthcodelab.mvx.mvc.model.bean.Book

class BookListView {

    private lateinit var binding: ActivityBookListBinding

    private lateinit var bookListAdapter: BookListAdapter

    fun initView(activity: Activity) {
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_book_list)
        bookListAdapter = BookListAdapter()
        binding.recyclerBookList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookListAdapter
        }
    }

    fun showBookList(bookList: List<Book>) {
        bookListAdapter.update(bookList)
    }
}
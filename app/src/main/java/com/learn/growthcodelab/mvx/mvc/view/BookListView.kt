package com.learn.growthcodelab.mvx.mvc.view

import android.app.Activity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.ActivityBookListBinding
import com.learn.growthcodelab.mvx.mvc.controller.BookListController
import com.learn.growthcodelab.mvx.mvc.model.BookDataModel
import com.learn.growthcodelab.mvx.mvc.model.bean.Book

class BookListView {

    private lateinit var binding: ActivityBookListBinding

    private lateinit var bookListAdapter: BookListAdapter

    private var bookListController: BookListController = BookListController(BookDataModel(), this)

    fun initView(activity: Activity) {
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_book_list)
        bookListAdapter = BookListAdapter()
        binding.recyclerBookList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookListAdapter
        }

        binding.btnBookListReorder.setOnClickListener {
            bookListController.reorderBook()
        }

        binding.btnBookListAdd.setOnClickListener {
            bookListController.addBook("New Book")
        }
    }

    fun showAllBooks() {
        bookListController.showBookList()
    }

    fun showBookList(bookList: List<Book>) {
        bookListAdapter.updateAllBooks(bookList)
    }

    fun displayNewlyAddedBook(book: Book) {
        bookListAdapter.addBook(book)
    }

}
package com.learn.growthcodelab.mvx.mvc.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityBookListBinding
import com.learn.growthcodelab.mvx.mvc.controller.BookListController
import com.learn.growthcodelab.mvx.mvc.model.BookDataModel

class BookListActivity: BaseActivity(){

    private lateinit var bookListController: BookListController
    private val bookListView: BookListView = BookListView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookListView.initView(this)
        bookListController = BookListController(BookDataModel(), bookListView)
        bookListController.showBookList()
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, BookListActivity::class.java))
        }
    }
}
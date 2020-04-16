package com.learn.growthcodelab.mvx.mvc.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.learn.growthcodelab.activity.BaseActivity

class BookListActivity: BaseActivity(){

    private val bookListView: BookListView = BookListView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookListView.initView(this)

        bookListView.showAllBooks()
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, BookListActivity::class.java))
        }
    }
}
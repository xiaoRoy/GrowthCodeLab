package com.learn.growthcodelab.mvx.mvc.controller

import com.learn.growthcodelab.mvx.mvc.model.BookDataModel
import com.learn.growthcodelab.mvx.mvc.view.BookListView

class BookListController(
        private val booksDataModel: BookDataModel,
        private val bookListView: BookListView
) {


    fun showBookList() {
        bookListView.showBookList(booksDataModel.getAllBooks())
    }

    fun addBook(title: String) {
        booksDataModel.addBook(title) {
            bookListView.displayNewlyAddedBook(it)
        }
    }

    fun reorderBook() {
        bookListView.showBookList(booksDataModel.reorderBooks())
    }
}
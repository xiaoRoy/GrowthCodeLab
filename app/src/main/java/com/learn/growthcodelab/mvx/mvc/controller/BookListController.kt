package com.learn.growthcodelab.mvx.mvc.controller

import com.learn.growthcodelab.mvx.mvc.model.BookDataModel
import com.learn.growthcodelab.mvx.mvc.view.BookListView

class BookListController(
        private val booksDataModel: BookDataModel,
        private val bookListView: BookListView
) {

    fun setup() {
        bookListView.reorderBooksAction = {
           bookListView.showBookList(booksDataModel.reorderBooks())
        }
    }

    fun showBookList() {
        bookListView.showBookList(booksDataModel.getAllBooks())
    }

    fun addBook(id: String, title: String) {

    }
}
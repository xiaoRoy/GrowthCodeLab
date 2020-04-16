package com.learn.growthcodelab.mvx.mvc.model

import com.learn.growthcodelab.mvx.mvc.model.bean.Book

class BookDataModel {

    private val books: MutableList<Book> = mutableListOf()

    init {
        books.addAll((0 until 44).map {
            val id = it.toString()
            Book(id, "Book:$id")
        })
    }

    fun getAllBooks(): List<Book> {
        return books
    }

    fun reorderBooks(): List<Book> {
        books.shuffle()
        return books
    }

    fun addBook(title: String, onBookAdded: (Book) -> Unit) {
        //net work...
        onBookAdded(Book(books.size.toString(), title))
    }
}
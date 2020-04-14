package com.learn.growthcodelab.mvx.mvc.model

import com.learn.growthcodelab.mvx.mvc.model.bean.Book

class BookDataModel {

    fun getAllBooks(): List<Book> {
        return (0 until 44).map {
            val id = it.toString()
            Book(id, "Book:$id")
        }
    }
}
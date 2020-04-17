package com.learn.growthcodelab.mvx.mvc.model

import com.learn.growthcodelab.mvx.mvc.model.bean.Book

class BookDataModel : BookObservable {

    private val books: MutableList<Book> = mutableListOf()

    private val bookObservers: MutableSet<BookObserver> = mutableSetOf()

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
        onBookAdded(Book(books.size.toString(), title).also { books.add(it) })
    }

    override fun registryObserver(bookObserver: BookObserver) {
        bookObservers.add(bookObserver)
    }

    fun addBookActive(title: String) {
        bookObservers.forEach { bookObserver ->
            bookObserver.onBookAdded(Book(books.size.toString(), title).also { books.add(it) })
        }
    }

    override fun removeObserver(bookObserver: BookObserver) {
    }
}
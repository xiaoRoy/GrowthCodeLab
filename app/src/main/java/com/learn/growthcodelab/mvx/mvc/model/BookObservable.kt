package com.learn.growthcodelab.mvx.mvc.model

import com.learn.growthcodelab.mvx.mvc.model.bean.Book

interface BookObservable {

    fun registryObserver(bookObserver: BookObserver)

    fun removeObserver(bookObserver: BookObserver)
}

interface BookObserver {
    fun onBookAdded(book: Book)
}
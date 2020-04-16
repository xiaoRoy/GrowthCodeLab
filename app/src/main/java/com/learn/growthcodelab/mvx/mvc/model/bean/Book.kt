package com.learn.growthcodelab.mvx.mvc.model.bean

class Book(
        val id: String,
        val title: String
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Book) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
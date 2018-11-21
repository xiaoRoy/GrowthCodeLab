package com.learn.growthcodelab.architecture.jetpack.product.model

import java.util.*

data class Product(
        val id: Int,
        val name: String,
        val description: String,
        val price: Double
) {
    val comments: MutableList<Comment> = mutableListOf()
}

data class Comment(
        val id: Int,
        val productId: Int,
        val content: String,
        val postAt: Date
)

interface Test {
    val name: String
}
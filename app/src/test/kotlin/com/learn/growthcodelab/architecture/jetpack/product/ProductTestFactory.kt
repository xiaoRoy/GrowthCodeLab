package com.learn.growthcodelab.architecture.jetpack.product

import com.learn.growthcodelab.architecture.jetpack.product.model.Product


object ProductTestFactory {


    fun createProducts() : List<Product>{
        val productA = Product(10, "Tag Watch", "Good", 322.0)
        val productB = Product(11, "Sun Glass", "Top", 122.0)
        val productC = Product(12, "Switch", "", 66.0)
        return listOf(productA, productB, productC)
    }
}
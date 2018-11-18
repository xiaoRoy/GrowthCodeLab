package com.learn.growthcodelab.architecture.jetpack.product.data

import android.arch.lifecycle.LiveData
import com.learn.growthcodelab.architecture.jetpack.product.model.Comment
import com.learn.growthcodelab.architecture.jetpack.product.model.Product

interface ProductDataSource {

    fun loadAllProducts(): LiveData<List<Product>>

    fun loadProduct(productId: Int): LiveData<Product>

    fun loadComments(productId: Int): LiveData<List<Comment>>

    fun searchProducts(query: String): LiveData<Product>
}
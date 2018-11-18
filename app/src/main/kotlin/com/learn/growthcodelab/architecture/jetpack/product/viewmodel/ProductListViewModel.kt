package com.learn.growthcodelab.architecture.jetpack.product.viewmodel

import android.arch.lifecycle.*
import com.learn.growthcodelab.architecture.jetpack.product.data.ProductDataSource
import com.learn.growthcodelab.architecture.jetpack.product.model.Product

class ProductListViewModel(val productDataSource: ProductDataSource) : ViewModel(){

//    val productList: MediatorLiveData<List<Product>> = MediatorLiveData()

    lateinit var allProducts: LiveData<List<Product>>

    init {
//        productList.addSource(productDataSource.loadAllProducts(), productList::setValue)
    }

    fun searchProducts(query: String): LiveData<Product> = productDataSource.searchProducts(query)

    fun loadAllProducts(): LiveData<List<Product>> = productDataSource.loadAllProducts()
}
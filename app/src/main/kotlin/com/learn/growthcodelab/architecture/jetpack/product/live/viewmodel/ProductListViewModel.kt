package com.learn.growthcodelab.architecture.jetpack.product.live.viewmodel

import android.arch.lifecycle.*
import com.learn.growthcodelab.architecture.jetpack.product.live.data.ProductDataSource
import com.learn.growthcodelab.architecture.jetpack.product.model.Product

class ProductListViewModel(private val productDataSource: ProductDataSource) : ViewModel(){

    private val productsWithDescription: MutableLiveData<List<Product>> = MutableLiveData()

    fun searchProducts(query: String): LiveData<Product> = productDataSource.searchProducts(query)

    fun loadAllProducts(): LiveData<List<Product>> = productDataSource.loadAllProducts()

    fun loadProductWithDescrition(): MutableLiveData<List<Product>> {
        return Transformations.map(loadAllProducts()){
            it.filter {
                product -> product.description.isNotBlank()
            }
        } as MutableLiveData
    }
}
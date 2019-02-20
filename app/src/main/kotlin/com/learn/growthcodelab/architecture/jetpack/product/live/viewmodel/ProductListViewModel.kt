package com.learn.growthcodelab.architecture.jetpack.product.live.viewmodel

import androidx.lifecycle.*
import com.learn.growthcodelab.architecture.jetpack.product.live.data.ProductDataSource
import com.learn.growthcodelab.architecture.jetpack.product.model.Comment
import com.learn.growthcodelab.architecture.jetpack.product.model.Product

class ProductListViewModel(private val productDataSource: ProductDataSource) : ViewModel(){

//    private val productsWithDescription: MutableLiveData<List<Product>> = MutableLiveData()

    fun searchProducts(query: String): LiveData<Product> = productDataSource.searchProducts(query)

    fun loadAllProducts(): LiveData<List<Product>> = productDataSource.loadAllProducts()

    fun loadProductWithDescription(): MutableLiveData<List<Product>> {
        return Transformations.map(loadAllProducts()){
            it.filter {
                product -> product.description.isNotBlank()
            }
        } as MutableLiveData
    }


    fun loadProduct(productId: Int) {

         val productInfo = MediatorLiveData<Product>()
        val productLiveData: LiveData<Product> = productDataSource.loadProduct(productId)
        val commentLiveData: LiveData<List<Comment>> = productDataSource.loadComments(productId)
        productInfo.addSource(productLiveData, object : Observer<Product> {
            override fun onChanged(product: Product?) {
              /*  commentLiveData.value?.let {
                    product?.comments?.addAll(it)
                    productInfo.value = product
                }*/
            }
        })
        productInfo.addSource(commentLiveData, object : Observer<List<Comment>> {
            override fun onChanged(comments: List<Comment>?) {
                /*productLiveData.value?.let {
                    if (comments != null) {
                        it.comments.addAll(comments)
                    }
                }*/
            }
        })
    }

    private fun zipProductInfo(productLiveData: LiveData<Product>, commentLiveData: LiveData<List<Comment>>) {
    }
}
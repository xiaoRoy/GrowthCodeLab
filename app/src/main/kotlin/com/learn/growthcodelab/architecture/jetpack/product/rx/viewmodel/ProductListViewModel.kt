package com.learn.growthcodelab.architecture.jetpack.product.rx.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.learn.growthcodelab.architecture.jetpack.product.model.Product
import com.learn.growthcodelab.architecture.jetpack.product.rx.data.ProductDataSource
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class ProductListViewModel(private val productDataSource: ProductDataSource) : ViewModel() {

    val allProducts = MutableLiveData<List<Product>>()


    fun loadAllProducts() {
        productDataSource
                .loadAllProducts().subscribe(object : SingleObserver<List<Product>> {
                    override fun onSuccess(productList: List<Product>) {
                        allProducts.value = productList
                    }

                    override fun onSubscribe(disposable: Disposable) {
                    }

                    override fun onError(exception: Throwable) {
                    }
                }
                )
    }
}
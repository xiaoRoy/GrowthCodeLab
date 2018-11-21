package com.learn.growthcodelab.architecture.jetpack.product.rx.data

import com.learn.growthcodelab.architecture.jetpack.product.model.Product
import io.reactivex.Single

interface ProductDataSource {

    fun loadAllProducts(): Single<List<Product>>
}

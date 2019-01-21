package com.learn.growthcodelab.recycler.loadmore

class Product (val id: String){
    val name: String = "Product Name $id"

    companion object {
        fun generateProducts(start: Int, amount: Int = 10) =
                (start until amount).map { Product(it.toString()) }
    }
}
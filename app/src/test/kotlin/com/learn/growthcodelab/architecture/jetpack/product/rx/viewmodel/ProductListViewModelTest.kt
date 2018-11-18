package com.learn.growthcodelab.architecture.jetpack.product.rx.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.learn.growthcodelab.architecture.jetpack.product.model.Product
import com.learn.growthcodelab.architecture.jetpack.product.rx.data.ProductDataSource
import io.reactivex.Single
import io.reactivex.SingleObserver
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito

class ProductListViewModelTest {

    @Rule
    @JvmField
    val instantExecutor = InstantTaskExecutorRule()

    private lateinit var productListViewModel: ProductListViewModel

    @Mock
    private lateinit var productDataSource: ProductDataSource

    @Captor
    private lateinit var allProductsCaptor: ArgumentCaptor<SingleObserver<List<Product>>>

    @Before
    fun setup() {
        productListViewModel = ProductListViewModel(productDataSource)
    }

    @Test
    fun test_loadAllProducts_empty() {
        val allProducts = Single.just(emptyList<Product>())
        Mockito.`when`(productDataSource.loadAllProducts()).thenReturn(allProducts)
        productListViewModel.loadAllProducts()
        Mockito.verify(productDataSource).loadAllProducts()

    }
}
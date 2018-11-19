package com.learn.growthcodelab.architecture.jetpack.product.rx.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.learn.growthcodelab.architecture.jetpack.product.ProductTestFactory
import com.learn.growthcodelab.architecture.jetpack.product.model.Product
import com.learn.growthcodelab.architecture.jetpack.product.rx.data.ProductDataSource
import com.learn.growthcodelab.capture
import com.learn.growthcodelab.mock
import io.reactivex.Single
import io.reactivex.SingleObserver
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.*

class ProductListViewModelTest {

    @Rule
    @JvmField
    val instantExecutor = InstantTaskExecutorRule()

    private lateinit var productListViewModel: ProductListViewModel

    @Mock
    private lateinit var productDataSource: ProductDataSource

    @Captor
    private lateinit var allProductsCaptor: ArgumentCaptor<List<Product>>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        productListViewModel = ProductListViewModel(productDataSource)
    }

    @Test
    fun test_loadAllProducts_empty() {
        val allProducts = Single.just(emptyList<Product>())
        Mockito.`when`(productDataSource.loadAllProducts()).thenReturn(allProducts)
        productListViewModel.loadAllProducts()
        val observer = mock<Observer<List<Product>>>()
        productListViewModel.allProducts.observeForever(observer)
        Mockito.verify(observer).onChanged(capture(allProductsCaptor))
        Assert.assertTrue(allProductsCaptor.value.isEmpty())
    }

    @Test
    fun tst_loadAllProducts() {
         val allProducts = Single.just(ProductTestFactory.createProducts())
        Mockito.`when`(productDataSource.loadAllProducts()).thenReturn(allProducts)
        productListViewModel.loadAllProducts()
        val observer = mock<Observer<List<Product>>>()
        productListViewModel.allProducts.observeForever(observer)
        Mockito.verify(observer).onChanged(capture(allProductsCaptor))
        Assert.assertEquals(3, allProductsCaptor.value.size)
    }
}
package com.learn.growthcodelab.architecture.jetpack.product.rx.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.learn.growthcodelab.any
import com.learn.growthcodelab.architecture.jetpack.product.ProductTestFactory
import com.learn.growthcodelab.architecture.jetpack.product.model.Product
import com.learn.growthcodelab.architecture.jetpack.product.rx.data.ProductDataSource
import com.learn.growthcodelab.capture
import com.learn.growthcodelab.mock
import io.reactivex.Single
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.*
import java.io.IOException

class ProductListViewModelTest {

    @Rule
    @JvmField
    val instantExecutor = InstantTaskExecutorRule()

    private lateinit var productListViewModel: ProductListViewModel

    @Mock
    private lateinit var productDataSource: ProductDataSource

    @Captor
    private lateinit var productsCaptor: ArgumentCaptor<List<Product>>

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
        Mockito.verify(observer).onChanged(capture(productsCaptor))
        Assert.assertTrue(productsCaptor.value.isEmpty())
    }

    @Test
    fun test_loadAllProducts() {
        val allProducts = Single.just(ProductTestFactory.createProducts())
        Mockito.`when`(productDataSource.loadAllProducts()).thenReturn(allProducts)
        productListViewModel.loadAllProducts()
        val observer = mock<Observer<List<Product>>>()
        productListViewModel.allProducts.observeForever(observer)
        Mockito.verify(observer).onChanged(capture(productsCaptor))
        Assert.assertEquals(3, productsCaptor.value.size)
    }

    @Test
    fun test_loadAllProducts_error() {
        val allProducts = Single.error<List<Product>>(IOException())
        Mockito.`when`(productDataSource.loadAllProducts()).thenReturn(allProducts)
        productListViewModel.loadAllProducts()
        val observer = mock<Observer<List<Product>>>()
        productListViewModel.allProducts.observeForever(observer)
        Mockito.verify(observer, Mockito.never()).onChanged(any())
    }

    @Test
    fun test_loadProductWithComments () {
        val allProducts = Single.just(ProductTestFactory.createProducts())
        Mockito.`when`(productDataSource.loadAllProducts()).thenReturn(allProducts)
        productListViewModel.loadProductsWithDescription()
        val observer = mock<Observer<List<Product>>>()
        productListViewModel.productsWithDescription.observeForever(observer)
        Mockito.verify(observer).onChanged(capture(productsCaptor))
        Assert.assertEquals(2, productsCaptor.value.size)
    }
}
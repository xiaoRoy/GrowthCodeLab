package com.learn.growthcodelab.architecture.jetpack.product.live.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.learn.growthcodelab.architecture.jetpack.product.ProductTestFactory
import com.learn.growthcodelab.architecture.jetpack.product.live.data.ProductDataSource
import com.learn.growthcodelab.architecture.jetpack.product.live.viewmodel.ProductListViewModel
import com.learn.growthcodelab.architecture.jetpack.product.model.Product
import com.learn.growthcodelab.capture
import com.learn.growthcodelab.mock
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.*

class ProductListViewModelTest {

    @Rule
    @JvmField
    val instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var productDataSource: ProductDataSource

    @Captor
    private lateinit var allProductsCaptor: ArgumentCaptor<List<Product>>

    private lateinit var productListViewModel: ProductListViewModel

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        productListViewModel = ProductListViewModel(productDataSource)
    }

    @Test
    fun test_loadAllProducts_empty() {
        val allProducts = MutableLiveData<List<Product>>()
        allProducts.value = emptyList()
        Mockito.`when`(productDataSource.loadAllProducts()).thenReturn(allProducts)
        val observer = mock<Observer<List<Product>>>()
        productListViewModel.loadAllProducts().observeForever(observer)
        Mockito.verify(observer).onChanged(capture(allProductsCaptor))
        Assert.assertTrue(allProductsCaptor.value.isEmpty())
    }

    @Test
    fun test_loadAllProducts() {
        val allProducts = MutableLiveData<List<Product>>()
        allProducts.value = ProductTestFactory.createProducts()
        Mockito.`when`(productDataSource.loadAllProducts()).thenReturn(allProducts)
        val observer = mock<Observer<List<Product>>>()
        productListViewModel.loadAllProducts().observeForever(observer)
        Mockito.verify(observer).onChanged(capture(allProductsCaptor))
        Assert.assertEquals(3, allProductsCaptor.value.size)
    }
}
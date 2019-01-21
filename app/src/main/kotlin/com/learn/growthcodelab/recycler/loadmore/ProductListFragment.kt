package com.learn.growthcodelab.recycler.loadmore

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentProductListBinding
import com.learn.growthcodelab.fragment.BaseFragment

class ProductListFragment : BaseFragment() {

    private lateinit var binding: FragmentProductListBinding

    private lateinit var productAdapter: ProductAdapter

    companion object {
        fun newInstance() = ProductListFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_product_list

    override fun bindView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        productAdapter = ProductAdapter(Product.generateProducts(0).toMutableList())
        binding.recyclerProduct.layoutManager = GridLayoutManager(activity, 2)
        binding.recyclerProduct.adapter = productAdapter
    }
}
package com.learn.growthcodelab.viewshowcase

import android.content.Context
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentViewShowcaseBinding
import com.learn.growthcodelab.fragment.BaseFragment

class ViewShowcaseFragment : BaseFragment(){

    private lateinit var viewShowcaseNavigator: ViewShowcaseNavigator

    companion object {
        fun newInstance() = ViewShowcaseFragment()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewShowcaseNavigator = if (context is ViewShowcaseNavigator) context
                                else throw IllegalArgumentException()
    }


    override fun getLayoutRes() = R.layout.fragment_view_showcase

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = DataBindingUtil.inflate<FragmentViewShowcaseBinding>(inflater, layoutRes, container, false)
        binding.navigator = viewShowcaseNavigator
        return binding.root
    }
}
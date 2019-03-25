package com.learn.growthcodelab.fragment.transaction

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentSecondBinding
import com.learn.growthcodelab.fragment.PlayGroundAbstractFragment

class SecondFragment : PlayGroundAbstractFragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var binding:FragmentSecondBinding

    override fun getLayoutRes() = R.layout.fragment_second

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.listener = View.OnClickListener { navigator.findTheFirstOne() }
        return binding.root
    }
}
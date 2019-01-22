package com.learn.growthcodelab.fragment.transaction

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentFirstBinding
import com.learn.growthcodelab.fragment.PlayGroundAbstractFragment

class FirstFragment : PlayGroundAbstractFragment() {

    private lateinit var binding: FragmentFirstBinding

    companion object {
        fun newInstance() = FirstFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_first

    override fun bindView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.listener = View.OnClickListener { navigator.navigateToSecondPage() }
        return binding.root
    }

    override fun enableLifeCycleLog(): Boolean {
        return true
    }


}
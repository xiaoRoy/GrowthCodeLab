package com.learn.growthcodelab.databinding.notify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentPhoneBinding
import com.learn.growthcodelab.databinding.model.Phone
import com.learn.growthcodelab.fragment.BaseFragment

class PhoneFragment : BaseFragment() {

    private lateinit var viewModel: PhoneViewModel

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val phone = Phone("123", "Apple", 399.0, "White")
        viewModel = PhoneViewModel().apply { this.phone = phone }
        return DataBindingUtil.inflate<FragmentPhoneBinding>(layoutInflater, layoutRes, container, false).apply {
            viewModel = this@PhoneFragment.viewModel
        }.root
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_phone
    }

    companion object {
        fun newInstance() = PhoneFragment()
    }
}
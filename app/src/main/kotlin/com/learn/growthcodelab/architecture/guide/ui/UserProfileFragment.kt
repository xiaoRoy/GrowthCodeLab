package com.learn.growthcodelab.architecture.guide.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.databinding.FragmentUserProfileBinding
import com.learn.growthcodelab.fragment.BaseFragment

class UserProfileFragment : BaseFragment() {

    companion object {
        private const val UID_KEY = "uid"
    }


    override fun bindView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentUserProfileBinding
                = DataBindingUtil.inflate(layoutInflater, layoutRes, container, false)
        return binding.root
    }
}
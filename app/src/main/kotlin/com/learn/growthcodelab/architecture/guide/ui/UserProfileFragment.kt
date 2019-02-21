package com.learn.growthcodelab.architecture.guide.ui

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.architecture.guide.model.User
import com.learn.growthcodelab.architecture.guide.viewmodel.UserProfileViewModel
import com.learn.growthcodelab.databinding.FragmentUserProfileBinding
import com.learn.growthcodelab.fragment.BaseFragment

class UserProfileFragment : BaseFragment() {

    companion object {
        private const val UID_KEY = "uid"
    }

    private lateinit var userProfileViewModel: UserProfileViewModel


    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentUserProfileBinding = DataBindingUtil.inflate(layoutInflater, layoutRes, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userProfileViewModel = ViewModelProviders.of(this).get(UserProfileViewModel::class.java)
        userProfileViewModel.user.observe(this, Observer<User> {
            TODO("update UI")
        })
    }
}
package com.learn.growthcodelab.architecture.guide.viewmodel

import android.arch.lifecycle.ViewModel
import com.learn.growthcodelab.architecture.guide.repository.UserProfileRepository

class UserProfileViewModel(private val userProfileRepository: UserProfileRepository) : ViewModel() {

    fun getUser() = userProfileRepository.getUser()
}
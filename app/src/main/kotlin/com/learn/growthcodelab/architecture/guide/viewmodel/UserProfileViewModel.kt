package com.learn.growthcodelab.architecture.guide.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.learn.growthcodelab.architecture.guide.model.User
import com.learn.growthcodelab.architecture.guide.repository.UserProfileRepository

class UserProfileViewModel(private val userProfileRepository: UserProfileRepository) : ViewModel() {

    lateinit var user: LiveData<User>
        private set

    fun init(userId: String) {
        if (!this::user.isInitialized) {
            user = userProfileRepository.getUser(userId)
        }
    }
}
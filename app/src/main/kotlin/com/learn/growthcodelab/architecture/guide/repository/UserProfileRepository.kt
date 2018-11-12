package com.learn.growthcodelab.architecture.guide.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.learn.growthcodelab.architecture.guide.model.User

class UserProfileRepository {

    private companion object {
        private val userMock = User("123", "Smith")
    }

    /*
    * Mock fetch the user from the remote
    * */
    fun getUser(userId: String) : LiveData<User> {
        val user = MutableLiveData<User>()
        user.value = userMock
        return user
    }
}
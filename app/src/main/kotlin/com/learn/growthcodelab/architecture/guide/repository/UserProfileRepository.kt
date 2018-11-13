package com.learn.growthcodelab.architecture.guide.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.learn.growthcodelab.architecture.guide.model.User

class UserProfileRepository(private val userCache: UserCache) {

    private companion object {
        private val userMock = User("123", "Smith")
    }


    fun getUser(userId: String) : LiveData<User> {
        var user = MutableLiveData<User>()
        if (userCache.isEmpty(userId)) {
            //Mock fetch the user from the remote, not handle the api error.
            user.value = userMock
            userCache.cache(userId, user)
        } else {
            user = userCache.get(userId)
        }
        return user
    }
}
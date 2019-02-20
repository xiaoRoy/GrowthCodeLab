package com.learn.growthcodelab.architecture.guide.repository

import androidx.lifecycle.MutableLiveData
import com.learn.growthcodelab.architecture.guide.model.User

class UserCache() {
    private var cachedUsers = mutableMapOf<String, MutableLiveData<User>>()

    fun isEmpty(userId: String) = cachedUsers.containsKey(userId)

    fun cache(userId: String, user: MutableLiveData<User>) {
        cachedUsers[userId] = user
    }

    fun get(userId: String) = cachedUsers.getValue(userId)
}
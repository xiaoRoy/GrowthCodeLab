package com.learn.growthcodelab.architecture.guide.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityUserProfileBinding

class UserProfileActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityUserProfileBinding>(this, R.layout.activity_user_profile)
    }
}
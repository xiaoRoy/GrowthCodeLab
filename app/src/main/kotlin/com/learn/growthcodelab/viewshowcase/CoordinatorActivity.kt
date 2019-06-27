package com.learn.growthcodelab.viewshowcase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityCoordinatorBinding

class CoordinatorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityCoordinatorBinding>(this, R.layout.activity_coordinator)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, CoordinatorActivity::class.java))
        }
    }
}
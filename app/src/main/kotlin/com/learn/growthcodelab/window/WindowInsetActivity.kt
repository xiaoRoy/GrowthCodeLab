package com.learn.growthcodelab.window

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityWindowInsetBinding

class WindowInsetActivity : BaseActivity(){

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, WindowInsetActivity::class.java))
        }
    }

    private lateinit var binding: ActivityWindowInsetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_window_inset)
        window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }
}
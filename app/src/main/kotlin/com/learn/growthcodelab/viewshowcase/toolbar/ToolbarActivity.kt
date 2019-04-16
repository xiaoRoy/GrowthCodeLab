package com.learn.growthcodelab.viewshowcase.toolbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityToolbarBinding

class ToolbarActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ToolbarActivity::class.java))
        }
    }

    private lateinit var binding: ActivityToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_toolbar)
        setTheme()
      /*  val shadow = LayoutInflater.from(this).inflate(R.layout.layout_shadow_pre_lollipop, binding.toolbarToolbar, false)
        val layoutParams: Toolbar.LayoutParams = shadow.layoutParams as Toolbar.LayoutParams
        layoutParams.gravity = Gravity.BOTTOM
        binding.toolbarToolbar.addView(shadow, layoutParams)*/
    }
}
package com.learn.growthcodelab.viewshowcase.viewpager2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity

class ViewPager2Activity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_2)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fl_view_pager_2_container, CategoryFragment.newInstance(), null)
                    .addToBackStack(null)
                    .commit()
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ViewPager2Activity::class.java))
        }
    }

}
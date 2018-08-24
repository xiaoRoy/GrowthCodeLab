package com.learn.growthcodelab.viewshowcase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity

class ViewShowcaseActivity : BaseActivity(){

    companion object {
        fun start(context: Context){
            context.startActivity(Intent(context, ViewShowcaseActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_view_showcase)
        if(savedInstanceState == null){
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fl_view_showcase_container, ViewShowcaseFragment.newInstance(), "View Showcase")
                    .commit()
        }
    }
}
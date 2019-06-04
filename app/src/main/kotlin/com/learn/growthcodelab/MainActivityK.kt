package com.learn.growthcodelab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.learn.growthcodelab.databinding.ActivityMainBinding

class MainActivityK : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
                .getNavigation().observe(this, Observer {

                })
    }

    private companion object {
        val navigationMap: MutableMap<Int, (Unit) -> Unit> = mutableMapOf()
    }
}
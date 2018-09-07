package com.learn.growthcodelab.search

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Menu
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity() {

    private lateinit var binding: ActivitySearchBinding

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SearchActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        setSupportActionBar(binding.toolbarSearch)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        menu?.let{
            val menuItem = it.findItem(R.id.action_search)
            menuItem.expandActionView()
        }

        return super.onCreateOptionsMenu(menu)
    }

}
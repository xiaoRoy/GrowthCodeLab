package com.learn.growthcodelab.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityDictionaryBinding

class DictionaryActivity : BaseActivity(), View.OnClickListener {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, DictionaryActivity::class.java))
        }
    }

    private lateinit var binding: ActivityDictionaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dictionary)
        binding.onClickListener = this
    }

    override fun onClick(view: View?) {
        onSearchRequested()
    }
}
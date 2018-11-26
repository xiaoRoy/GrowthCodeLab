package com.learn.growthcodelab.architecture.jetpack.word.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity

class WordsActivity : BaseActivity() {

    companion object {
        fun start(context: Context){
            context.startActivity(Intent(context, WordsActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.fl_words_container, WordsFragment.newInstance(), "Words")
                    .addToBackStack("Show Words")
                    .commit()
        }
    }
}
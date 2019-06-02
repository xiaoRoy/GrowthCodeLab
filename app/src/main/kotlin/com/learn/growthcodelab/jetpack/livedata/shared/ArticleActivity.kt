package com.learn.growthcodelab.jetpack.livedata.shared

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityArticleBinding

class ArticleActivity: BaseActivity(), ArticleNavigator {

    private lateinit var articleSharedViewModel: ArticleSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityArticleBinding>(this, R.layout.activity_article)
        if(savedInstanceState == null) {

        }

        articleSharedViewModel = obtainArticleSharedViewModel().apply {
            navigateToArticleDetail.observe(this@ArticleActivity, Observer {
                it.getContentIfNotHandled()?.let {

                }
            })
        }
    }

    override fun obtainArticleSharedViewModel(): ArticleSharedViewModel {
        return ViewModelProviders.of(this).get(ArticleSharedViewModel::class.java)
    }
}
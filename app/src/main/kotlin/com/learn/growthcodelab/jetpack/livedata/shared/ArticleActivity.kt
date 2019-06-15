package com.learn.growthcodelab.jetpack.livedata.shared

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fl_article_container, ArticleListFragment())
                    .commit()
        }

        articleSharedViewModel = obtainArticleSharedViewModel().apply {
            navigateToArticleDetail.observe(this@ArticleActivity, Observer {
                it.getContentIfNotHandled()?.let { title ->
                    replaceFragment(ArticleDetailFragment.newInstance(title), "Article Detail")
                }
            })
        }
    }

    override fun obtainArticleSharedViewModel(): ArticleSharedViewModel {
        return ViewModelProviders.of(this).get(ArticleSharedViewModel::class.java)
    }

    private fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_article_container, fragment, tag)
                .addToBackStack(null)
                .commit()
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ArticleActivity::class.java))
        }
    }
}
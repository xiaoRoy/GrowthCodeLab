package com.learn.growthcodelab.jetpack.livedata.shared

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.learn.growthcodelab.aboutfragment.FragmentActivity
import java.lang.IllegalArgumentException

class ArticleLifeCycleAwareness {


    lateinit var articleNavigator: ArticleNavigator
        private set

    lateinit var articleSharedViewModel: ArticleSharedViewModel
        private set

    fun onArticleAttach(context: Context?) {
        /*articleNavigator = if (context is ArticleNavigator) context
        else throw IllegalArgumentException("The host Activity should implement the ArticleNavigator")*/

        articleNavigator = (context as? ArticleNavigator)
                ?: throw IllegalArgumentException("The host Activity should implement the ArticleNavigator")

        articleSharedViewModel = (context as? FragmentActivity)
                ?.let { ViewModelProviders.of(it).get(ArticleSharedViewModel::class.java) }
                ?: throw IllegalArgumentException("The host Activity should be FragmentActivity")
    }
}
package com.learn.growthcodelab.jetpack.livedata.shared

import android.content.Context
import java.lang.IllegalArgumentException

class ArticleLifeCycleAwareness {


    lateinit var articleNavigator: ArticleNavigator
        private set

    fun onArticleAttach(context: Context?) {
        articleNavigator = if (context is ArticleNavigator) context
        else throw IllegalArgumentException("The host Activity should implement the ArticleNavigator")
    }
}
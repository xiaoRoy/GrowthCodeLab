package com.learn.growthcodelab.jetpack.livedata.shared

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentArticleDetailBinding
import com.learn.growthcodelab.fragment.BaseFragment

class ArticleDetailFragment : BaseFragment() {

    private val articleLifeCycleAwareness: ArticleLifeCycleAwareness = ArticleLifeCycleAwareness()

    private lateinit var title: String

    override fun getLayoutRes(): Int {
        return R.layout.fragment_article_detail
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        articleLifeCycleAwareness.onArticleAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(BUNDLE_KEY_ARTICLE_TITLE)
                ?: throw IllegalArgumentException("Should put he title into the bundle")
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return DataBindingUtil.inflate<FragmentArticleDetailBinding>(layoutInflater, layoutRes, container, false)
                .apply {
                    sharedViewModel = articleLifeCycleAwareness.articleSharedViewModel
                    title = this@ArticleDetailFragment.title
                }.root
    }

    companion object {
        private const val BUNDLE_KEY_ARTICLE_TITLE = "bundle_key_article_title"
        fun newInstance(title: String) = ArticleDetailFragment().apply {
            arguments = Bundle(1).apply {
                putString(BUNDLE_KEY_ARTICLE_TITLE, title)
            }
        }
    }
}
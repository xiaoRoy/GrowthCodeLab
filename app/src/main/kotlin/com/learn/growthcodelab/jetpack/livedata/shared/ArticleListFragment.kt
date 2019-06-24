package com.learn.growthcodelab.jetpack.livedata.shared

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentArticleListBinding
import com.learn.growthcodelab.fragment.BaseFragment

class ArticleListFragment : BaseFragment() {

    private val articleLifeCycleAwareness: ArticleLifeCycleAwareness = ArticleLifeCycleAwareness()

    private lateinit var binding: FragmentArticleListBinding
    private lateinit var articleListViewModel: ArticleListViewModel

    override fun getLayoutRes(): Int {
        return R.layout.fragment_article_list
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        articleLifeCycleAwareness.onArticleAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articleLifeCycleAwareness.articleSharedViewModel.titleUpdated.observe(this, Observer {
            it.getContentIfNotHandled()?.let { title ->
                if (::binding.isInitialized) {
                    binding.title = title
                }
            }
        })


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title = getString(R.string.how_to_be_happy)
        binding.btnArticleLike.setOnClickListener { articleListViewModel.like() }
        ViewModelProviders.of(this).get(ArticleListViewModel::class.java).also { articleListViewModel = it }
                .likeAmount.observe(this, Observer {
            println("trail.like")
            binding.tvArticleLikeAmount.text = it.toString()
        })
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            DataBindingUtil.inflate<FragmentArticleListBinding>(inflater, layoutRes, container, false)
                    .apply { sharedViewModel = articleLifeCycleAwareness.articleSharedViewModel }
                    .also { binding = it }
                    .root
}
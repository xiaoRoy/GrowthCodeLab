package com.learn.growthcodelab.jetpack.livedata.shared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.DialogTitle
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentArticleListBinding
import com.learn.growthcodelab.fragment.BaseFragment

class ArticleDetailFragment : BaseFragment() {

    override fun getLayoutRes(): Int {
         return R.layout.fragment_article_list
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return DataBindingUtil.inflate<FragmentArticleListBinding>(
                layoutInflater, layoutRes, container, false).root
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
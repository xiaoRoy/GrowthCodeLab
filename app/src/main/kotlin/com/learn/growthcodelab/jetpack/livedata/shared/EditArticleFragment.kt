package com.learn.growthcodelab.jetpack.livedata.shared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentEditArticleBinding
import com.learn.growthcodelab.fragment.BaseFragment

class EditArticleFragment : BaseFragment() {

    private lateinit var title: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(BUNDLE_KEY_ARTICLE_TITLE)
                ?: throw IllegalArgumentException("Should put he title into the bundle")
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return DataBindingUtil.inflate<FragmentEditArticleBinding>(inflater, layoutRes, container, false)
                .apply {  }.root
    }

    override fun getLayoutRes(): Int = R.layout.fragment_edit_article

    companion object {
        private const val BUNDLE_KEY_ARTICLE_TITLE = "bundle_key_title"

        fun newInstance(title: String) =
                EditArticleFragment().apply {
                    arguments = Bundle().apply {
                        putString(BUNDLE_KEY_ARTICLE_TITLE, title)
                    }
                }
    }
}
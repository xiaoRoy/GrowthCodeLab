package com.learn.growthcodelab.jetpack.livedata.shared

import android.os.Bundle
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class EditArticleFragment : BaseFragment() {


    override fun getLayoutRes(): Int = R.layout.fragment_edit_article

    companion object {
        private const val BUNDLE_KEY_TITLE = "bundle_key_title"

        fun newInstance(title: String) =
                EditArticleFragment().apply {
                    arguments = Bundle().apply {
                        putString(BUNDLE_KEY_TITLE, title)
                    }
                }
    }
}
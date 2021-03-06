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
import com.learn.growthcodelab.architecture.mvvmlive.Event
import com.learn.growthcodelab.databinding.FragmentEditArticleBinding
import com.learn.growthcodelab.fragment.BaseFragment

class EditArticleFragment : BaseFragment() {

    private lateinit var title: String

    private lateinit var editArticleViewModel: EditArticleViewModel

    private lateinit var binding: FragmentEditArticleBinding

    private val articleLifeCycleAwareness = ArticleLifeCycleAwareness()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        articleLifeCycleAwareness.onArticleAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        title = arguments?.getString(BUNDLE_KEY_ARTICLE_TITLE)
//                ?: throw IllegalArgumentException("Should put he title into the bundle")
        title = "title"

        val addedBooksInfo = arguments?.getParcelable<ArticleActivity.AddedBooksInfo>(BUNDLE_KEY_ADDED_BOOK_INFO)
        println("trail:${addedBooksInfo?.count}")
        println("trail:${addedBooksInfo?.books}")
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return DataBindingUtil.inflate<FragmentEditArticleBinding>(inflater, layoutRes, container, false)
                .apply {
                    setLifecycleOwner(this@EditArticleFragment)
                }
                .also { binding = it }
                .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editArticleViewModel = ViewModelProviders.of(this,
                EditArticleViewModelFactory.genInstance(articleLifeCycleAwareness.articleSharedViewModel))
                .get(EditArticleViewModel::class.java)
                .also { binding.editArticleViewModel = it }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        editArticleViewModel.title.value = title
    }

    override fun getLayoutRes(): Int = R.layout.fragment_edit_article

   /* private fun saveTitle(title: String) {
        articleLifeCycleAwareness.articleSharedViewModel.titleUpdated.value = Event(title)
    }*/

    companion object {
        private const val BUNDLE_KEY_ARTICLE_TITLE = "bundle_key_title"
        private const val BUNDLE_KEY_ADDED_BOOK_INFO = "added_book_info"

        fun newInstance(title: String) =
                EditArticleFragment().apply {
                    arguments = Bundle().apply {
                        putString(BUNDLE_KEY_ARTICLE_TITLE, title)
                    }
                }

        fun newInstanceWithAddedBooksInfo(addedBooksInfo: ArticleActivity.AddedBooksInfo) =
                EditArticleFragment().apply {
                    arguments = Bundle(1).apply {
                        putParcelable(BUNDLE_KEY_ADDED_BOOK_INFO, addedBooksInfo)
                    }
                }

    }
}
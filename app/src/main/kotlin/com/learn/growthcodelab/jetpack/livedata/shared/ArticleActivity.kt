package com.learn.growthcodelab.jetpack.livedata.shared

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityArticleBinding

class ArticleActivity : BaseActivity(), ArticleNavigator {

    private lateinit var articleSharedViewModel: ArticleSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityArticleBinding>(this, R.layout.activity_article)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fl_article_container, ArticleListFragment())
                    .commit()
        }

        articleSharedViewModel = obtainArticleSharedViewModel().apply {
            navigateToArticleDetail.observe(this@ArticleActivity, Observer {
                it.getContentIfNotHandled()?.let { title ->
//                    replaceFragment(ArticleDetailFragment.newInstance(title), "Article Detail")
                    replaceFragment(EditArticleFragment.newInstanceWithAddedBooksInfo(AddedBooksInfo.createAddedBooksInfo()), "Edit Article")
                }
            })
            navigateToEditArticle.observe(this@ArticleActivity, Observer {
                it.getContentIfNotHandled()?.let { title ->
                    replaceFragment(EditArticleFragment.newInstance(title), "Edit Article")


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

    class Book(val id: String, val name: String)

    class AddedBooksInfo(val count: Int, val books: List<Book>, val owner: String? = null) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                mutableListOf<Book>(),
                parcel.readString()) {
            parcel.readList(books, books::class.java.classLoader)
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(count)
            parcel.writeString(owner)
            parcel.writeList(books)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<AddedBooksInfo> {
            override fun createFromParcel(parcel: Parcel): AddedBooksInfo {
                return AddedBooksInfo(parcel)
            }

            override fun newArray(size: Int): Array<AddedBooksInfo?> {
                return arrayOfNulls(size)
            }

            fun createAddedBooksInfo(): AddedBooksInfo {
                val books = listOf(Book("123", "What"), Book("444", "where"))
                return AddedBooksInfo(4, books, "No One")
            }
        }

    }
}
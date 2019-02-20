package com.learn.growthcodelab.databinding.twoway

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentBookBinding
import com.learn.growthcodelab.databinding.model.Book
import com.learn.growthcodelab.fragment.BaseFragment

class BookFragment : BaseFragment(), View.OnClickListener {


    private var book: Book = Book("Peter", "Peter Book")

    private lateinit var fragmentBookBinding: FragmentBookBinding


    companion object {
        fun newInstance() = BookFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_book

    override fun bindView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBookBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        fragmentBookBinding.onClickedListener = this
        return fragmentBookBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentBookBinding.book = book
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_book_show_log -> {
                println("trail.BookAuthor:${book.author}")
                println("trail.BookTitle:${book.title}")
            }
            R.id.btn_book_change ->{
                println("trail.change")
                book.title = "Mocking Bird"
                book.author = "Who?"
            }
        }

    }
}
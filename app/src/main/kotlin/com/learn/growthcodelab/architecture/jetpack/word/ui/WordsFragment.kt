package com.learn.growthcodelab.architecture.jetpack.word.ui

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learn.growthcodelab.R
import com.learn.growthcodelab.architecture.jetpack.word.viewmodel.WordsViewModel
import com.learn.growthcodelab.databinding.FragmentWordsBinding
import com.learn.growthcodelab.fragment.BaseFragment

class WordsFragment : BaseFragment() {

    private lateinit var wordsAdapter: WordsAdapter

    private lateinit var binding: FragmentWordsBinding

    private lateinit var wordsViewModel: WordsViewModel

    companion object {
        fun newInstance() = WordsFragment()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_words
    }

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?,
                          savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate<FragmentWordsBinding>(inflater, layoutRes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordsAdapter = WordsAdapter()
        wordsViewModel = ViewModelProviders.of(this).get(WordsViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerWords.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.recyclerWords.adapter = wordsAdapter
        wordsViewModel.allWords.observe(this,
                Observer { allWords ->
                    wordsAdapter.updateWords(allWords)
                })
    }

}
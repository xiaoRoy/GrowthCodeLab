package com.learn.growthcodelab.rx.cheese

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.widget.SimpleTextWatcher
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CheeseActivity : BaseActivity() {

    private lateinit var btnCheeseSearch: Button
    private lateinit var etCheeseSearch: EditText
    private lateinit var recyclerCheese: RecyclerView
    private lateinit var progressCheese: ProgressBar

    private lateinit var cheeseProvider: CheeseProvider
    private lateinit var cheesesAdapter: CheesesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheeses)
        btnCheeseSearch = findViewById(R.id.btn_cheese_search)
        etCheeseSearch = findViewById(R.id.et_cheese_search)
        recyclerCheese = findViewById(R.id.recycler_cheese)
        progressCheese = findViewById(R.id.progress_cheeses)
        cheeseProvider = CheeseProvider()
        cheesesAdapter = CheesesAdapter()
        recyclerCheese.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cheesesAdapter
        }

    }


    @SuppressLint("CheckResult")
    override fun onStart() {
        super.onStart()
        val searchButtonClick = createSearchButtonClickObservable()
        val searchQueryChange = createSearchQueryChangeObservable()
        Observable.merge<String>(searchButtonClick, searchQueryChange)
                .doOnNext { showProgress(true) }
                .observeOn(Schedulers.io())
                .flatMap { cheeseProvider.search(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showCheeseSearchResult)


    }

    private fun createSearchButtonClickObservable(): Observable<String> = Observable.create { emitter ->
        btnCheeseSearch.setOnClickListener {
            emitter.onNext(etCheeseSearch.text.toString())
        }
        emitter.setCancellable {
            Log.d(TAG, "Click, setCancellable")
            btnCheeseSearch.setOnClickListener(null)
        }
    }

    private fun showCheeseSearchResult(cheeses: List<Cheese>) {
        showProgress(false)
        cheesesAdapter.updateCheese(cheeses)
    }


    private fun showProgress(isVisible: Boolean) {
        val visibility = if (isVisible) View.VISIBLE else View.GONE
        progressCheese.visibility = visibility
    }

    private fun createSearchQueryChangeObservable(): Observable<String> =
            Observable.create<String> { emitter ->
                val textWatcher = object : SimpleTextWatcher() {
                    override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                        charSequence?.let { emitter.onNext(it.toString()) }
                    }
                }
                etCheeseSearch.addTextChangedListener(textWatcher)
                emitter.setCancellable {
                    etCheeseSearch.removeTextChangedListener(textWatcher)
                }
            }
                    .filter { it.length >= QUERY_MINIMUM_LENGTH }
                    .debounce(1, TimeUnit.SECONDS)


    companion object {
        const val TAG = "cheese"
        const val QUERY_MINIMUM_LENGTH = 2
        fun start(context: Context) {
            context.startActivity(Intent(context, CheeseActivity::class.java))
        }
    }

}
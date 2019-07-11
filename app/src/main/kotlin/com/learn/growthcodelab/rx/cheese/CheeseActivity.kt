package com.learn.growthcodelab.rx.cheese

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import io.reactivex.Observable

class CheeseActivity : BaseActivity() {

    private lateinit var btnCheeseSearch: Button
    private lateinit var etCheeseSearch: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheeses)
        btnCheeseSearch = findViewById(R.id.btn_cheese_search)
        etCheeseSearch = findViewById(R.id.et_cheese_search)
    }

    private fun createSearchButtonClickObservable(): Observable<String> = Observable.create { emitter ->
        btnCheeseSearch.setOnClickListener {
            emitter.onNext(etCheeseSearch.text.toString())
        }
        emitter.setCancellable {
            btnCheeseSearch.setOnClickListener(null)
        }
    }
}
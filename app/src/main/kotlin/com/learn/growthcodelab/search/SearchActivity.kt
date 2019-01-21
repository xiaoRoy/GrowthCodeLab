package com.learn.growthcodelab.search

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.database.MatrixCursor
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.provider.BaseColumns
import android.support.v4.widget.CursorAdapter
import android.support.v4.widget.SimpleCursorAdapter
import android.support.v7.widget.SearchView
import android.view.Menu
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity() {

    private lateinit var binding: ActivitySearchBinding

    private lateinit var suggestionsAdapter: CursorAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        setSupportActionBar(binding.toolbarSearch)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        suggestionsAdapter = SimpleCursorAdapter(
                this,
                R.layout.item_city_suggestion,
                null,
                arrayOf(COLUMN_NAME_CITY),
                arrayOf(android.R.id.text1).toIntArray(),
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER)
        searchView.suggestionsAdapter = suggestionsAdapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                updateSuggestion(newText)
                return true
            }
        })
        return true
    }

    private fun updateSuggestion(query: String){
        val matrixCursor = MatrixCursor(arrayOf(BaseColumns._ID, COLUMN_NAME_CITY))
        CITYS.toList().filter {
            it.contains(query, true)
        }.forEachIndexed { index, element ->
            matrixCursor.addRow(arrayOf(index, element))
        }
       suggestionsAdapter.changeCursor(matrixCursor)
    }


    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SearchActivity::class.java))
        }

        private const val COLUMN_NAME_CITY = "city_name"

        private val CITYS = arrayOf("Beijing", "London", "Manchester", "New York", "Tokyo", "Paris", "ABQ",
                "Beijing",  "Beijing",  "Beijing",  "Beijing", "Beijing", "Beijing"
        )
    }
}
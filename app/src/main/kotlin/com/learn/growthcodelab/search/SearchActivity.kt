package com.learn.growthcodelab.search

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.database.MatrixCursor
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.provider.BaseColumns
import androidx.appcompat.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.cursoradapter.widget.CursorAdapter
import androidx.cursoradapter.widget.SimpleCursorAdapter
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity() {

    private lateinit var binding: ActivitySearchBinding

    private lateinit var suggestionsAdapter: androidx.cursoradapter.widget.CursorAdapter

    private lateinit var searchView: SearchView

    private lateinit var addMenuItem: MenuItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        setSupportActionBar(binding.toolbarSearch)
        binding.btnPerformSearch.setOnClickListener(View.OnClickListener {
            println("trail.isIconified ${searchView.isIconified}")
            searchView.isIconified = !searchView.isIconified
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        addMenuItem = menu.findItem(R.id.action_add)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        menu.findItem(R.id.action_search).setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                addMenuItem.isVisible = true
                return true
            }

            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                addMenuItem.isVisible = false
                return true
            }
        })
        menu.findItem(R.id.action_search).expandActionView()

        searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.queryHint = "what"
//        searchView.setIconifiedByDefault(false)
//        addMenuItem.isVisible = false

//        searchView.setOnSearchClickListener {
//            addMenuItem.isVisible = false
//        }
//
//        searchView.setOnCloseListener {
//            addMenuItem.isVisible = true
//            false
//        }

//        searchView.onActionViewExpanded()
//        searchView.isIconified = true
        searchView.maxWidth = Int.MAX_VALUE
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

    private fun updateSuggestion(query: String) {
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
                "Beijing", "Beijing", "Beijing", "Beijing", "Beijing", "Beijing"
        )
    }
}
package com.learn.growthcodelab.viewshowcase.tabhost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TabHost
import android.widget.TabWidget
import android.widget.TextView
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class TabHostFragment : BaseFragment() {


    companion object {
        fun newInstance() = TabHostFragment()
    }

    private lateinit var tabHost: TabHost
    private lateinit var tabWidget: TabWidget
    private lateinit var tabContent: FrameLayout


    override fun getLayoutRes() = R.layout.fragment_tab_host


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            tabHost = findViewById(android.R.id.tabhost) as TabHost
            tabHost.setup()
            tabWidget = findViewById(android.R.id.tabs) as TabWidget
            tabContent = findViewById(android.R.id.tabcontent) as FrameLayout
        }
        initTab()
    }

    private fun initTab() {
        val tabNames = listOf("Tab A", "Tab B", "Tab C")
        val tabContentFactory = TabHost.TabContentFactory { tag ->
            val textView = LayoutInflater.from(context).inflate(R.layout.layout_tab_content, tabContent, false) as TextView
            textView.text = tag
            textView
        }
        tabNames.forEach {
            val tab = tabHost.newTabSpec(it).apply {
                setIndicator(it)
                setContent(tabContentFactory)
            }
            tabHost.addTab(tab)
        }
    }
}
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
        val tabA = tabHost.newTabSpec("Tab A")
        val tabB = tabHost.newTabSpec("Tab B")
        val tabC = tabHost.newTabSpec("Tab C")

        val xx = TabHost.TabContentFactory { tag ->
            val textView = LayoutInflater.from(view.context).inflate(R.layout.layout_tab_content, tabContent, false) as TextView
            textView.text = tag
            textView
        }

        tabA.setIndicator("Tab A")
        tabB.setIndicator("Tab B")
        tabC.setIndicator("Tab C")
        tabA.setContent(xx)
        tabB.setContent(xx)
        tabC.setContent(xx)
        tabHost.addTab(tabA)
        tabHost.addTab(tabB)
        tabHost.addTab(tabC)
    }
}
package com.learn.growthcodelab.databinding.twoway

import android.view.View
import android.widget.TextView

interface ShowLogCallback {
    fun onShowLogClicked(view: View, log: String)
    fun onShowLogClicked(targetView: TextView)
}
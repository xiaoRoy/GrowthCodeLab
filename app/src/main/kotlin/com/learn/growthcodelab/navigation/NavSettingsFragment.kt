package com.learn.growthcodelab.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class NavSettingsFragment: BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_nav_settings
    }
}
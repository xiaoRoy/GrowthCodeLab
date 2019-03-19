package com.learn.growthcodelab.window.drawer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityDrawerBinding

class DrawerActivity : BaseActivity(), DrawerNavigator {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, DrawerActivity::class.java))
        }
    }

    private lateinit var binding: ActivityDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_drawer)
        binding.flDrawerContent.setOnApplyWindowInsetsListener{view, inset -> view.onApplyWindowInsets(inset)}
       /* binding.flDrawerContent.setOnApplyWindowInsetsListener { view, insets ->
            var consumed = false
            (view as ViewGroup).run {
                for (index in 0 until childCount) {
                    val child = getChildAt(index)
                    val childResult = child.dispatchApplyWindowInsets(insets)
                    if (childResult.isConsumed) {
                        consumed = true
                    }
                    if (child.id == R.id.fl_container_drawer_a) {
                        Log.d("trail", "drawer a")
                        Log.d("trail", "drawer a.consumed:$consumed")
                    }
                }
            }
             Log.d("trail", "drawer a, left:${insets.systemWindowInsetLeft}")
             Log.d("trail", "drawer a, top:${insets.systemWindowInsetTop}")
             Log.d("trail", "drawer a, right:${insets.systemWindowInsetRight}")
             Log.d("trail", "drawer a, bottom:${insets.stableInsetBottom}")
            if (consumed) insets.consumeSystemWindowInsets() else insets
        }*/
        if(savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fl_drawer_content, DrawerAFragment.newInstance(), "drawer a")
                    .commit()
        }
    }

    override fun navigateToDrawerB() {
         supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fl_drawer_content, DrawerBFragment.newInstance(), "drawer B")
                    .addToBackStack("add to B")
                    .commit()
    }

    override fun backToDrawerA() {
        supportFragmentManager.popBackStack()
    }
}
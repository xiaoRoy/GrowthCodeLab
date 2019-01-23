package com.learn.growthcodelab.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.fragment.transaction.FirstFragment
import com.learn.growthcodelab.fragment.transaction.SecondFragment

class FragmentPlayGroundActivity
    : BaseActivity(), FragmentPlayGroundNavigator {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, FragmentPlayGroundActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_play_ground)
        initOperation()
    }

    private fun initOperation() {
        findViewById<View>(R.id.btn_play_ground_op).setOnClickListener { removeFirstOne()  }
    }

    private fun addFirstFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fl_fragment_play_ground_container, FirstFragment.newInstance(), "First")
                    .commit()
        }
    }
    /*
    * Try to remove the fragment in xml
    *
    * */
    private fun removeFirstOne() {
        val fragment = supportFragmentManager.findFragmentByTag("First")
        fragment?.run {
            supportFragmentManager.beginTransaction().remove(this).commit()
            Log.d("trail", "Removed")
        }
    }

    override fun findTheFirstOne() {
        val fragment = supportFragmentManager.findFragmentByTag("First")
        val msg = if (fragment == null) "null" else "not null"
        Log.d("FragmentPlayGround", msg)
    }


    override fun navigateToSecondPage() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fl_fragment_play_ground_container, SecondFragment.newInstance(), "second")
                .addToBackStack("Replace To Second")
                .commit()
    }
}
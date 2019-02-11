package com.learn.growthcodelab.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.fragment.state.PopBackListener
import com.learn.growthcodelab.fragment.state.StateDashboardFragment
import com.learn.growthcodelab.fragment.state.StateDetailsFragment
import com.learn.growthcodelab.fragment.transaction.FirstFragment
import com.learn.growthcodelab.fragment.transaction.SecondFragment
import kotlin.math.log

class FragmentPlayGroundActivity
    : BaseActivity(), FragmentPlayGroundNavigator {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, FragmentPlayGroundActivity::class.java))
        }
    }

    private val fragmentSates: MutableList<Fragment.SavedState> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_play_ground)
        showStateDashboard(savedInstanceState)
        initOperation()
    }

    private fun initOperation() {
        findViewById<View>(R.id.btn_play_ground_op).setOnClickListener {  showStateDetails()  }
    }

    private fun showStateDashboard(savedInstanceState: Bundle?) {
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fl_fragment_play_ground_container, StateDashboardFragment.newInstance(), "state_dashboard")
//                    .addToBackStack("add_state_dashboard")
                    .commit()
        }
    }

    private fun showStateDetails() {
        val fragmentManager = supportFragmentManager
       /* val fragment: Fragment? = fragmentManager.findFragmentByTag("state_dashboard")
        if(fragment != null && fragment.isAdded) {
           fragmentSates.add(fragmentManager.saveFragmentInstanceState(fragment))
        }*/
        fragmentManager
                .beginTransaction()
                .replace(R.id.fl_fragment_play_ground_container, StateDetailsFragment.newInstance(), "state_details")
                .addToBackStack("replace_state_details")
                .commit()
    }

    private fun removeStateDashboard() {
        val fragment: Fragment? = supportFragmentManager.findFragmentByTag("state_dashboard")
        if (fragment != null && fragment.isAdded) {
            supportFragmentManager
                    .beginTransaction()
                    .remove(fragment)
                    .commit()
        }

    }

    override fun onBackPressed() {
        /*val fragment: Fragment? = supportFragmentManager.findFragmentByTag("state_dashboard")
        if (fragment is PopBackListener) {
            if(fragmentSates.isNotEmpty()) {
                Log.d("trail","removeStateDashboard${fragment.isAdded}")
                fragment.setInitialSavedState(fragmentSates[0])
            }
        }*/
        super.onBackPressed()
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
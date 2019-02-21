package com.learn.growthcodelab.viewshowcase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.fragment.BaseFragment
import com.learn.growthcodelab.viewshowcase.tabhost.TabHostFragment

class ViewShowcaseActivity : BaseActivity(), ViewShowcaseNavigator{


    companion object {
        fun start(context: Context){
            context.startActivity(Intent(context, ViewShowcaseActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_view_showcase)
        if(savedInstanceState == null){
            val fragmentTag = BaseFragment.getFragmentTag(ViewShowcaseFragment::class.java)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fl_view_showcase_container, ViewShowcaseFragment.newInstance(), fragmentTag)
                    .commit()
        }
    }

    override fun navigateToSpanPage() {
        supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fl_view_showcase_container, SpanFragment.newInstance(), "span")
                    .commit()
    }

    override fun navigateToImageViewPage() {
    }

    override fun navigateToTabHostPage() {
         supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fl_view_showcase_container, TabHostFragment.newInstance(), "tab_host")
                    .commit()
    }

}
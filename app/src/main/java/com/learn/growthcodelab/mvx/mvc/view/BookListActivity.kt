package com.learn.growthcodelab.mvx.mvc.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityBookListBinding

class BookListActivity: BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityBookListBinding>(this, R.layout.activity_book_list)
    }
}
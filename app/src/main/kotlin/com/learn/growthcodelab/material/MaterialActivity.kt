package com.learn.growthcodelab.material

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.chip.Chip
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityMaterialBinding

class MaterialActivity : BaseActivity() {

    private var lastCheckedId = View.NO_ID


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMaterialBinding>(this, R.layout.activity_material).apply {
//            chipGroupOptions.setOnCheckedChangeListener { group, checkedId ->
//                if(checkedId == View.NO_ID) {
//                    group.check(lastCheckedId)
//                } else {
//                    lastCheckedId = checkedId
//                }
//            }
//            for(index in 0 until  chipGroupOptions.childCount) {
//                val child = chipGroupOptions.getChildAt(index)
//                if(child is Chip) {
//                    child.setOnTouchListener { view, event ->
//                        child.isChecked
//                    }
//                }
//            }
        }

    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MaterialActivity::class.java))
        }
    }
}
package com.learn.growthcodelab.databinding.layout

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.LayoutRegistryTrackingWebviewBinding

class RegistryTrackingWebView : ConstraintLayout{
    constructor(context: Context?) : super(context){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init()
    }

    private fun init(){
        DataBindingUtil.inflate<LayoutRegistryTrackingWebviewBinding>(LayoutInflater.from(context), R.layout.layout_registry_tracking_webview, this, true)
    }
}
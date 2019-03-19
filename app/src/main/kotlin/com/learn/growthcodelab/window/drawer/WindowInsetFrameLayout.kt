package com.learn.growthcodelab.window.drawer

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.WindowInsets
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import java.util.*

class WindowInsetFrameLayout : FrameLayout {

    private var insets: Any? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    private fun init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && ViewCompat.getFitsSystemWindows(this)) {
            setOnApplyWindowInsetsListener { _, insets ->
                if (!Objects.equals(insets, this.insets)) {
                    this.insets = insets
                }
                insets.consumeSystemWindowInsets()
            }
        }
    }


    override fun onViewAdded(child: View) {
        super.onViewAdded(child)
        if(insets != null && child.fitsSystemWindows) {
            child.dispatchApplyWindowInsets(insets as WindowInsets)
        }
    }

    override fun onViewRemoved(child: View?) {
        super.onViewRemoved(child)
    }

}
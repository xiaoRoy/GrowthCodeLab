package com.learn.growthcodelab.window.drawer

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.WindowInsets
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import com.learn.growthcodelab.R
import java.util.*

class WindowInsetFrameLayout : FrameLayout {

    private var insets: Any? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context,
                attrs: AttributeSet?,
                defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init()
    }


    private fun init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && ViewCompat.getFitsSystemWindows(this)) {
            setOnApplyWindowInsetsListener { view, insets ->
                if (!Objects.equals(insets, this.insets)) {
                    this.insets = insets
                }
                if (this.childCount > 0 && getChildAt(childCount - 1) != null) {
                    val firstChild = this.getChildAt(childCount - 1)
//                    val firstChild = view.findViewById<View>(R.id.fl_container_drawer_b)
                    if (firstChild != null && ViewCompat.getFitsSystemWindows(firstChild)) {
                        firstChild.dispatchApplyWindowInsets(insets)
                        /*if (resultInset.isConsumed) {

                        }*/

                        insets.consumeSystemWindowInsets()
                    } else {
                        view.onApplyWindowInsets(insets)
                    }
                } else {
                    view.onApplyWindowInsets(insets)
                }
            }
        }
    }

    /*override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
        return if (this.childCount > 0 && getChildAt(childCount - 1) != null) {
//                    val firstChild = this.getChildAt(childCount - 1)
            val firstChild = findViewById<View>(R.id.fl_container_drawer_b)
            if (firstChild != null && ViewCompat.getFitsSystemWindows(firstChild)) {
//                insets.consumeSystemWindowInsets()
//                firstChild.dispatchApplyWindowInsets(insets)
                *//* if(resultInset.isConsumed) {

                 }*//*
                insets
            } else {
                super.onApplyWindowInsets(insets)
            }
        } else {
            super.onApplyWindowInsets(insets)
        }
    }*/


    override fun onViewAdded(child: View) {
        super.onViewAdded(child)
        /*if(insets != null && child.fitsSystemWindows) {
            child.dispatchApplyWindowInsets(insets as WindowInsets)
        }*/
    }

    override fun onViewRemoved(child: View?) {
        super.onViewRemoved(child)
    }

}
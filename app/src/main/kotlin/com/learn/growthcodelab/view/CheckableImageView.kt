package com.learn.growthcodelab.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Checkable
import androidx.appcompat.widget.AppCompatImageView

class CheckableImageView(context: Context,
                         attrs: AttributeSet?,
                         defStyleAttr: Int
) : AppCompatImageView(context, attrs, defStyleAttr), Checkable {

    private var checked = false

    private val checkStateArray = intArrayOf(android.R.attr.state_checked)

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        val drawableState  = super.onCreateDrawableState(extraSpace + 1)
        if(isChecked) {
            View.mergeDrawableStates(drawableState, checkStateArray)
        }
        return super.onCreateDrawableState(extraSpace)
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
    }

    override fun isChecked(): Boolean {
        return checked
    }

    override fun toggle() {
        isChecked = !checked
    }

    override fun setChecked(checked: Boolean) {
        if(this.checked != checked) {
            this.checked = checked
            refreshDrawableState()
        }
    }
}
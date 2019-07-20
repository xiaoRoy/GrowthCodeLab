package com.learn.growthcodelab.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Checkable
import androidx.appcompat.widget.AppCompatImageView
import com.learn.growthcodelab.R

class CheckableImageView(context: Context,
                         attrs: AttributeSet?,
                         defStyleAttr: Int
) : AppCompatImageView(context, attrs, defStyleAttr), Checkable {

    private var checked = false

    private val checkStateArray = intArrayOf(android.R.attr.state_checked)

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    init {
        val typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.CheckableImageView, defStyleAttr, 0)
        try {
            isChecked = typedArray.getBoolean(R.styleable.CheckableImageView_checked, false)
        }finally {
            typedArray.recycle()
        }
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        val drawableState = super.onCreateDrawableState(extraSpace + 1)
        if (isChecked) {
            View.mergeDrawableStates(drawableState, checkStateArray)
        }
        return drawableState
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

    override fun performClick(): Boolean {
        toggle()
        return super.performClick()
    }

    override fun setChecked(checked: Boolean) {
        if (this.checked != checked) {
            this.checked = checked
            refreshDrawableState()
        }
    }
}
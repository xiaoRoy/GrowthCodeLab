package com.learn.growthcodelab.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.annotation.Px
import com.learn.growthcodelab.R

class FilterFlowLayout : ViewGroup {

    private var maxCollapsedLine = DEFAULT_MAXIMUM_COLLAPSED_LINE

    @Px
    private var lineSpacing = 0

    @Px
    private var itemSpacing = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.FilterFlowLayout, defStyleAttr, 0)
        maxCollapsedLine = typedArray.getInt(R.styleable.FilterFlowLayout_maxCollapsedLine, DEFAULT_MAXIMUM_COLLAPSED_LINE)
        lineSpacing = typedArray.getDimensionPixelSize(R.styleable.FilterFlowLayout_lineSpacing, DEFAULT_LINE_SPACING)
        itemSpacing = typedArray.getDimensionPixelSize(R.styleable.FilterFlowLayout_itemSpacing, DEFAULT_ITEM_SPACING)
        typedArray.recycle()

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
    }

    companion object {
        const val DEFAULT_MAXIMUM_COLLAPSED_LINE = 2
        const val DEFAULT_LINE_SPACING = 0
        const val DEFAULT_ITEM_SPACING = 0
    }
}
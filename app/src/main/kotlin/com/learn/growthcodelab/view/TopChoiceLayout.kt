package com.learn.growthcodelab.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CompoundButton
import android.widget.FrameLayout
import androidx.appcompat.widget.SwitchCompat
import androidx.databinding.*
import com.learn.growthcodelab.R

class TopChoiceLayout : FrameLayout { 

    private lateinit var switchTopChoice: SwitchCompat

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_top_choice_inner, this, true)
        switchTopChoice = findViewById(R.id.switch_top_choice)
    }

    fun isTopChoice(): Boolean {
        return switchTopChoice.isChecked
    }

    fun setTopChoice(isTopChoice: Boolean) {
        switchTopChoice.isChecked = isTopChoice
    }

    fun setOnTopChoiceChangedListener(onCheckedChangeListener: CompoundButton.OnCheckedChangeListener) {
        switchTopChoice.setOnCheckedChangeListener(onCheckedChangeListener)
    }

    @InverseBindingMethods(InverseBindingMethod(type = TopChoiceLayout::class, attribute = "topChoice"))
    companion object {

        @InverseBindingAdapter(attribute = "topChoice")
        @JvmStatic fun isTopChoice(topChoiceLayout: TopChoiceLayout): Boolean {
            return topChoiceLayout.isTopChoice()
        }


        @BindingAdapter("topChoice")
        @JvmStatic fun setTopChoice(topChoiceLayout: TopChoiceLayout, topChoice: Boolean) {
            if (topChoice != topChoiceLayout.isTopChoice()) {
                topChoiceLayout.setTopChoice(topChoice)
            }
        }

        @BindingAdapter(value = ["topChoiceAttrChanged", "onTopChoiceChangedListener"], requireAll = false)
        @JvmStatic fun setOnTopChoiceChangedListener(
                topChoiceLayout: TopChoiceLayout,
                attrChange: InverseBindingListener?,
                onTopChoiceChangedListener: CompoundButton.OnCheckedChangeListener?
        ) {
            println("trail.setOnTopChoiceChangedListener")
            if (attrChange == null) {
                onTopChoiceChangedListener?.let {
                    topChoiceLayout.setOnTopChoiceChangedListener(it)
                }
            } else {
                topChoiceLayout.setOnTopChoiceChangedListener(
                        CompoundButton.OnCheckedChangeListener { switch: CompoundButton, isTopChoice: Boolean ->
                            onTopChoiceChangedListener?.onCheckedChanged(switch, isTopChoice)
                            println("trail.attrChange")
                            attrChange.onChange()
                        })
            }
        }
    }
}



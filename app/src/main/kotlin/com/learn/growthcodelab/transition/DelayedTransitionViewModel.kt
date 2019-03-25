package com.learn.growthcodelab.transition

import androidx.databinding.ObservableBoolean

class DelayedTransitionViewModel {

    val isCircleVisible = ObservableBoolean(true)

    interface OnDelayedTransitionClickListener{
        fun onChangSizeClicked()

        fun onChangeVisibilityClicked();
    }
}
package com.learn.growthcodelab.transition

import android.databinding.ObservableBoolean

class DelayedTransitionViewModel {

    val isCircleVisible = ObservableBoolean(true)

    interface OnDelayedTransitionClickListener{
        fun onChangSizeClicked()

        fun onChangeVisibilityClicked();
    }
}
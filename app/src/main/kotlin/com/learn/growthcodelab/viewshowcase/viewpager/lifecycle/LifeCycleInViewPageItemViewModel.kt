package com.learn.growthcodelab.viewshowcase.viewpager.lifecycle

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableBoolean
import com.learn.growthcodelab.BR

class LifeCycleInViewPageItemViewModel(likeItem: LikeItem) : BaseObservable() {

    val isTipVisible = ObservableBoolean()

    @get:Bindable
    var likeIndex: Int = likeItem.index
    set(value) {
        field = value
        notifyPropertyChanged(BR.likeIndex)
    }

    @get:Bindable
    var likeAmount: Int = likeItem.amount
    set(value) {
        field = value
        notifyPropertyChanged(BR.likeAmount)
    }
}
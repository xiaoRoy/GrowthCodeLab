package com.learn.growthcodelab.viewshowcase.viewpager.lifecycle

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableBoolean
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
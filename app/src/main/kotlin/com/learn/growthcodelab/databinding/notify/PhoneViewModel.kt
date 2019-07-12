package com.learn.growthcodelab.databinding.notify

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.learn.growthcodelab.BR
import com.learn.growthcodelab.databinding.model.Phone

class PhoneViewModel : BaseObservable() {

    @get: Bindable
    var phone: Phone? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.phone)
        }


    fun updatePhone() {
        phone?.color = "Orange"
    }
}
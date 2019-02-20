package com.learn.growthcodelab.databinding.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.learn.growthcodelab.BR


class Book (author: String, title: String): BaseObservable(){

    var author: String = author
    @Bindable get() {
        return field
    }
    set(value) {
        field = value
        notifyPropertyChanged(BR.author)
    }

    var title: String = title
    @Bindable
    get()  {
        return field
    }
    set(value) {
        field = value
        notifyPropertyChanged(BR.title)
    }
}



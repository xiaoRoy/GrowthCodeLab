package com.learn.growthcodelab.rx.cheese

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import com.learn.growthcodelab.rx.InitialValueObservable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

class TextViewChangesObservable(
        private val view: TextView
) : InitialValueObservable<CharSequence>() {

    override val initialValue: CharSequence
        get() = view.text

    override fun subscribed(observer: Observer<in CharSequence>) {
        val listener = Listener(view, observer)
        observer.onSubscribe(listener)
        view.addTextChangedListener(listener)
    }

    private class Listener(
            private val view: TextView,
            private val observer: Observer<in CharSequence>
    ) : MainThreadDisposable(), TextWatcher {
        override fun onDispose() {
            view.removeTextChangedListener(this)
        }

        override fun afterTextChanged(editable: Editable) {
        }

        override fun beforeTextChanged(CharSequence: CharSequence, start: Int, count: Int, after: Int) {
            if (!isDisposed) {
                observer.onNext(CharSequence)
            }
        }

        override fun onTextChanged(CharSequence: CharSequence, start: Int, before: Int, count: Int) {
        }
    }
}
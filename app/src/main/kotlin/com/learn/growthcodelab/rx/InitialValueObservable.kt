package com.learn.growthcodelab.rx

import io.reactivex.Observable
import io.reactivex.Observer

abstract class InitialValueObservable<T> : Observable<T>() {

    protected abstract val initialValue: T

    override fun subscribeActual(observer: Observer<in T>) {
        subscribed(observer)
    }

    protected abstract fun subscribed(observer: Observer<in T>)

    fun skipInitialValue(): Observable<T> = Skipped()

    private inner class Skipped : Observable<T>() {

        override fun subscribeActual(observer: Observer<in T>) {
            subscribed(observer)
        }
    }
}
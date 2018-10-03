package com.learn.growthcodelab.architecture.mvp

interface BaseView<P> {
    fun setPresenter(presenter: P)
}
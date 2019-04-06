package com.learn.growthcodelab.architecture.mvvmlive

open class Event<out T>(private val content: T) {

    var handled = false
    private set

    fun getContentIfNotHandled() : T? {
        return if(handled) {
            null
        } else {
            handled = true
            content
        }
    }

    fun peekContent(): T = content

}
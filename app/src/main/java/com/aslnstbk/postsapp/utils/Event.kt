package com.aslnstbk.postsapp.utils

open class Event<out T>(private val content: T) {

    var hasBeenHandled = false

    fun getContentIfHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}
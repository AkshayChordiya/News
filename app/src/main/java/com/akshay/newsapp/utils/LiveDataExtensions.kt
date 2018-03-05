package com.akshay.newsapp.utils

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

/**
 * Syntactic sugar for [LiveData.observe] function where the [Observer] is the last parameter.
 * Hence can be passed outside the function parenthesis.
 */
inline fun <T> LiveData<T>.observe(owner: LifecycleOwner, crossinline observer: (T) -> Unit) {
    this.observe(owner, Observer { it?.apply(observer) })
}
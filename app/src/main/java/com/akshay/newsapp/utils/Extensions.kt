package com.akshay.newsapp.utils

import android.support.annotation.StringRes
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import retrofit2.Retrofit

/**
 * Extension functions
 *
 * @author Akshay Chordiya
 * @since 5/23/2017.
 */

/**
 * Inflate the layout
 * @param layoutRes layout resource id
 */
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

/**
 * Easy toast function for Activity
 */
fun FragmentActivity.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

/**
 * Easy toast function for Activity
 */
fun FragmentActivity.toast(@StringRes stringRes: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, stringRes, duration).show()
}

/**
 * Easy retrofit create service
 */
inline fun <reified T> Retrofit.create(): T {
    return create(T::class.java)
}
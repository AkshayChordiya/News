package com.akshay.newsapp.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Synthetic sugaring to get instance of [ViewModel] for [AppCompatActivity].
 */
inline fun <reified T : ViewModel> AppCompatActivity.getViewModel(): T {
    return ViewModelProviders.of(this).get(T::class.java)
}

/**
 * Synthetic sugaring to get instance of [ViewModel] for [Fragment].
 */
inline fun <reified T : ViewModel> Fragment.getViewModel(): T {
    return ViewModelProviders.of(this).get(T::class.java)
}

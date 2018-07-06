package com.akshay.newsapp.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Synthetic sugaring to get instance of [ViewModel] for [AppCompatActivity].
 */
inline fun <reified T : ViewModel> AppCompatActivity.getViewModel(): T {
    return ViewModelProviders.of(this).get(T::class.java)
}

/**
 * Synthetic sugaring to get instance of [ViewModel] for [Fragment].
 */
inline fun <reified T : ViewModel> androidx.fragment.app.Fragment.getViewModel(): T {
    return ViewModelProviders.of(this).get(T::class.java)
}

package com.akshay.newsapp.core.utils

import retrofit2.Retrofit

// Retrofit

/**
 * Synthetic sugaring to create Retrofit Service.
 */
inline fun <reified T> Retrofit.create(): T = create(T::class.java)
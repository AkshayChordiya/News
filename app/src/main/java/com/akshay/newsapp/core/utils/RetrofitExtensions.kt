package com.akshay.newsapp.core.utils

import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import retrofit2.Retrofit

// Retrofit

/**
 * Synthetic sugaring to create Retrofit Service.
 */
inline fun <reified T> Retrofit.create(): T = create(T::class.java)

/**
 * Creates a fake error response.
 */
fun <T> httpError(code: Int): Response<T> = Response.error<T>(code, "".toResponseBody(null))
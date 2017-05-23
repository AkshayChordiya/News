package com.akshay.newsapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Utility class to build retrofit configuration.
 * Note: I'm not sure if it's the ideal way to keep retrofit
 * in companion object (static block kinda..)
 *
 * @author Akshay Chordiya
 * @since 5/23/2017.
 */
class RestApi {

    /**
     * Kinda like a static block in Java
     */
    companion object {
        val BASE_URL = "https://newsapi.org/v1/"
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}
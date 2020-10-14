package com.akshay.newsapp.news.Utilities

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


fun String.getFormattedDate(): Date? {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone("GMT")
    try {
        return dateFormat.parse(this)
    } catch (e: ParseException) {
        return null
    }
}
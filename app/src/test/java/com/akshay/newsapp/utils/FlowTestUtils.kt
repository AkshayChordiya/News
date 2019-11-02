package com.akshay.newsapp.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import org.junit.Assert.assertEquals

/**
 * Asserts only the [expected] items by just taking that many from the stream
 */
suspend fun <T> Flow<T>.assertItems(vararg expected: T) {
    assertEquals(this.take(expected.size).toList(), expected.toList())
}

/**
 * Takes all elements from the stream and asserts them.
 */
suspend fun <T> Flow<T>.assertCompleteStream(vararg expected: T) {
    assertEquals(this.toList(), expected.toList())
}
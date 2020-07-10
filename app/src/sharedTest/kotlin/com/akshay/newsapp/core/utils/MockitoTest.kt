package com.akshay.newsapp.core.utils

import org.junit.Before
import org.mockito.MockitoAnnotations

/**
 * Base class to support mocking
 * in tests.
 *
 * Example:
 * ```
 * class AbcTest: MockitoTest {
 *    @Mock
 *    lateinit var a: Abc
 * }
 *
 * ```
 */
abstract class MockitoTest {

    @Before
    open fun setup() {
        MockitoAnnotations.initMocks(this)
    }
}
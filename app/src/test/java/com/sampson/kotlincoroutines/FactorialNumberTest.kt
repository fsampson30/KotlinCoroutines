package com.sampson.kotlincoroutines

import org.junit.Test
import com.google.common.truth.Truth.assertThat
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FactorialNumberTest {
    private val factorial = FactorialNumber()

    @Test
    fun computesFactorial() {
        val n = 3
        val result = factorial.factorial(n)
        assertThat(result).isEqualTo(6)
    }
}
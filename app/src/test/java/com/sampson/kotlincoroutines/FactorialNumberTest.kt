package com.sampson.kotlincoroutines

import org.junit.Test
import com.google.common.truth.Truth.assertThat
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class FactorialNumberTest(
    private val input: Int,
    private val expected: Int
) {

    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun getData(): Collection<Array<Int>> = listOf(
            arrayOf(0, 1),
            arrayOf(1, 1),
            arrayOf(2, 2),
            arrayOf(3, 6),
            arrayOf(4, 24),
            arrayOf(5, 120)
        )
    }

    private val factorial = FactorialNumber()

    @Test
    fun computesFactorial() {
        val result = factorial.factorial(input)
        assertThat(result).isEqualTo(expected)
    }
}
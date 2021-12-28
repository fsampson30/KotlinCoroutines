package com.sampson.kotlincoroutines

import org.junit.Test
import com.google.common.truth.Truth.assertThat
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.math.BigInteger

@RunWith(Parameterized::class)
class FactorialNumberTest(
    private val input: Int,
    private val expected: BigInteger
) {

    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun getData(): Collection<Array<Any>> = listOf(
            arrayOf(0, BigInteger.ONE),
            arrayOf(1, BigInteger.ONE),
            arrayOf(2, BigInteger.valueOf(2)),
            arrayOf(3, BigInteger.valueOf(6)),
            arrayOf(4, BigInteger.valueOf(24)),
            arrayOf(5, BigInteger.valueOf(120)),
            arrayOf(13, BigInteger("6227020800")),
            arrayOf(25, BigInteger("15511210043330985984000000"))
        )
    }

    private val factorial = FactorialNumber()

    @Test
    fun computesFactorial() {
        val result = factorial.factorial(input)
        assertThat(result).isEqualTo(expected)
    }
}
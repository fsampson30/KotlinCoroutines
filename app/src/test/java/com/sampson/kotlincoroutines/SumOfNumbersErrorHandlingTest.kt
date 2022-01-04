package com.sampson.kotlincoroutines

import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner
import java.math.BigInteger
import kotlin.math.exp

@RunWith(MockitoJUnitRunner::class)
class SumOfNumbersErrorHandlingTest {
    @InjectMocks
    lateinit var sumOfNumbers: SumOfNumbers
    @Test(expected = SumOfNumbers.InvalidNumberException::class)
    fun sum() {
        val input = -1
        val callback = mock<(BigInteger) -> Unit>()
        sumOfNumbers.sum(input, callback)
    }
}
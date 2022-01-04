package com.sampson.kotlincoroutines

import java.math.BigInteger
import kotlin.jvm.Throws

class SumOfNumbers {
    @Throws(InvalidNumberException::class)
    fun sum(n: Int, callback: (BigInteger) -> Unit) {
        if (n < 0) {
            throw InvalidNumberException
        }
        var result = BigInteger.ZERO
        callback(n.toBigInteger().times(n.toBigInteger() + 1.toBigInteger()).divide(2.toBigInteger()))
    }
    object InvalidNumberException : Throwable()
}
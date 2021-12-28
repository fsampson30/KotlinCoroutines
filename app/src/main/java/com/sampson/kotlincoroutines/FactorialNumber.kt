package com.sampson.kotlincoroutines

import java.math.BigInteger
import kotlin.jvm.Throws

class FactorialNumber {

    companion object {
        var result: BigInteger = BigInteger.ONE
    }

    @Throws(FactorialNotFoundException::class)
    fun factorial(n: Int): BigInteger {
        if (n < 0) {
            throw FactorialNotFoundException
        }
        // Refactored to eliminate IntArray and usage of Memory, created a For Loop Instead.
        /*return IntArray(n) {
            it + 1
        }.fold( BigInteger.ONE, { acc, i ->
            acc * i.toBigInteger()
        } )*/
        for (i in 1..n){
            result = result.times(i.toBigInteger())
        }
        return result
    }

    object FactorialNotFoundException : Throwable()
}
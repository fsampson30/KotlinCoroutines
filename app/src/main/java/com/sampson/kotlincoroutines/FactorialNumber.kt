package com.sampson.kotlincoroutines

import kotlin.jvm.Throws

class FactorialNumber {
    @Throws(FactorialNotFoundException::class)
    fun factorial(n: Int): Int {
        if (n < 0) {
            throw FactorialNotFoundException
        }
        return IntArray(n) {
            it + 1
        }.fold( 1, { acc, i ->
            acc * i
        } )
    }
    object FactorialNotFoundException : Throwable()
}
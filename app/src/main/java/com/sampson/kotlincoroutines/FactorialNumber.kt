package com.sampson.kotlincoroutines

class FactorialNumber {
    fun factorial(n: Int): Int {
        return IntArray(n) {
            it + 1
        }.fold( 1, { acc, i ->
            acc * i
        } )
    }
}
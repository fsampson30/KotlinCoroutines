package com.sampson.kotlincoroutines

import org.junit.Assert.*
import org.junit.Test

class FactorialNumberTest2{
    private val factorial = FactorialNumber()

    @Test(expected = FactorialNumber.FactorialNotFoundException::class)
    fun computesNegatives(){
        factorial.factorial(-10)
    }


}


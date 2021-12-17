package com.sampson.kotlincoroutines

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun validateInput() {
        val input = "100"
        val result = Validator.validadeInput(input)
        assertThat(result).isTrue()
    }

    @Test
    fun invalidInput() {
        val input = ""
        val result = Validator.validadeInput(input)
        assertThat(result).isFalse()
    }

    @Test
    fun whenAddIsValid(){
        val value1 = 1
        val value2 = 2
        val result = Validator.add(value1,value2)
        assertThat(result).isGreaterThan(0)
    }

    @Test
    fun whenAddIsInvalid(){
        val value1 = 0
        val value2 = 0
        val result = Validator.add(value1,value2)
        assertThat(result).isAtLeast(0)
    }

    @Test
    fun whenDivideIsValid(){
        val value1 = 10
        val value2 = 2
        val result = Validator.divideInt(value1,value2)
        assertThat(result).isGreaterThan(0)
    }

    @Test(expected = ArithmeticException::class)
    fun whenDivideIsInvalid(){
        val value1 = 10
        val value2 = 0
        val result = Validator.divideInt(value1,value2)
        assertThat(result).isNull()
    }

    @Test
    fun whenDivideDoubleisInvalid(){
        val value1 = 10.0
        val value2 = 0.0
        val result = Validator.divideDouble(value1,value2)
        assertThat(result).isPositiveInfinity()
    }
}
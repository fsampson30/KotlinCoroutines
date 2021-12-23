package com.sampson.kotlincoroutines

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun validateInput() {
        val input = "100"
        val result = Validator.validateInput(input)
        assertThat(result).isTrue()
    }

    @Test
    fun invalidInput() {
        val input = ""
        val result = Validator.validateInput(input)
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
    fun whenDivideDoubleIsInvalid(){
        val value1 = 10.0
        val value2 = 0.0
        val result = Validator.divideDouble(value1,value2)
        assertThat(result).isPositiveInfinity()
    }

    @Test
    fun whenMultiplyIntIsValid(){
        val value1 = 2
        val value2 = 4
        val result = Validator.multiplyInt(value1,value2)
        assertThat(result).isGreaterThan(0)
    }

    @Test
    fun whenMultiplyDoubleIsValid() = runBlocking{
        val value1 = 15.6
        val value2 = 17.8
        val result = Validator.multiplyDouble(value1,value2)
        assertThat(result).isNonZero()
    }

    @Test
    fun whenSubtractIsValid(){
        val value1 = 10
        val value2 = 7
        val result = Validator.subtract(value1, value2)
        assertThat(result).isNotNull()

    }
}
package com.sampson.kotlincoroutines

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun validadeInput() {
        val input = "100"
        val result = Validator.validadeInput(input)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun invalidInput() {
        val input = ""
        val result = Validator.validadeInput(input)
        assertThat(result).isFalse()
    }
}
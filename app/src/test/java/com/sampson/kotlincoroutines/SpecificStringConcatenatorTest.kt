package com.sampson.kotlincoroutines

import com.google.common.truth.Truth
import org.junit.Test
import org.mockito.Mockito

class SpecificStringConcatenatorTest {
    private val stringConcatenator = Mockito.mock(StringConcatenator::class.java)
    private val specificStringConcatenator = SpecificStringConcatenator(stringConcatenator)

    @Test
    fun concatenateSpecificStrings(){
        val expected = "expected"
        Mockito.`when`(stringConcatenator.concatenate(R.string.string_1, R.string.string_2)).thenReturn(expected)
        val result = specificStringConcatenator.concatenateSpecificStrings()
        Truth.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun concatenateWithCallBack() {
        val expected =  "expected"
        Mockito.`when`(stringConcatenator.concatenate(R.string.string_1, R.string.string_2)).thenReturn(expected)
        val callback = Mockito.mock(SpecificStringConcatenator.Callback::class.java)
        specificStringConcatenator.concatenateWithCallBack(callback)
        Mockito.verify(callback).onStringReady(expected)
    }
}
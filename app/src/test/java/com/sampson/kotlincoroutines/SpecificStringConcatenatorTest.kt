package com.sampson.kotlincoroutines

import com.google.common.truth.Truth
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SpecificStringConcatenatorTest {
    @Mock
    lateinit var stringConcatenator: StringConcatenator
    @InjectMocks
    lateinit var specificStringConcatenator: SpecificStringConcatenator

    @Test
    fun concatenateSpecificStrings(){
        val expected = "expected"
        whenever(stringConcatenator.concatenate(R.string.string_1, R.string.string_2)).thenReturn(expected)
        val result = specificStringConcatenator.concatenateSpecificStrings()
        Truth.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun concatenateWithCallBack() {
        val expected =  "expected"
        val spy = Mockito.spy(specificStringConcatenator)
        whenever(spy.concatenateSpecificStrings()).thenReturn(expected)
        val callback = Mockito.mock(SpecificStringConcatenator.Callback::class.java)
        specificStringConcatenator.concatenateWithCallBack(callback)
        verify(callback).onStringReady(expected)
    }
}
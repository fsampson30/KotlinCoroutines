package com.sampson.kotlincoroutines

import android.content.Context
import org.junit.Test
import org.mockito.Mockito
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever

class StringConcatenatorTest {
    private val context = mock<Context>()
    private val stringConcatenator = StringConcatenator(context)

    @Test
    fun concatenate() {
        val stringRes1 = 1
        val stringRes2 = 2
        val string1 = "string1"
        val string2 = "string2"
        whenever(context.getString(stringRes1)).thenReturn(string1)
        whenever(context.getString(stringRes2)).thenReturn(string2)
        val result = stringConcatenator.concatenate(stringRes1,stringRes2)
        assertThat(string1.plus(string2)).isEqualTo(result)
    }
}
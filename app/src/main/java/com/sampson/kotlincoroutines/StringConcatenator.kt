package com.sampson.kotlincoroutines

import android.content.Context
import androidx.annotation.StringRes
import javax.security.auth.callback.Callback


class StringConcatenator(private val context: Context) {
    fun concatenate(@StringRes stringRes1: Int, @StringRes stringRes2: Int) : String {
        return context.getString(stringRes1).plus(context.getString(stringRes2))
    }
}
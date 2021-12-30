package com.sampson.kotlincoroutines

class SpecificStringConcatenator(private val stringConcatenator: StringConcatenator) {
    fun concatenateSpecificStrings(): String {
        return stringConcatenator.concatenate(R.string.string_1, R.string.string_2)
    }
}
package com.sampson.kotlincoroutines

object Validator {

    fun validadeInput(value : String) : Boolean{
        return !((value == null) || (value.isEmpty()))
    }
}
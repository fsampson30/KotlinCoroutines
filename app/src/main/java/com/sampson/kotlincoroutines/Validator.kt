package com.sampson.kotlincoroutines

object Validator {

    fun validadeInput(value : String) : Boolean{
        return !((value == null) || (value.isEmpty()))
    }

    fun add(value1 : Int, value2 : Int) : Int{
        return value1 + value2
    }

    fun divideInt(value1: Int, value2: Int) : Int{
        return value1 / value2
    }

    fun divideDouble(value1: Double, value2: Double) : Double{
        return value1 / value2
    }
}
package com.wangduwei.kotlin.basic.src.functions.Closure

fun main (){
    var number = 1

    fun incrementAndShow(){
        number++
        println(number)
    }

    for(x in 1..3)
        incrementAndShow()
}

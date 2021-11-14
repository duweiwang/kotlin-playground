package com.wangduwei.kotlin.basic.src.functions.ItVariable

fun main() {
    val primeNumbers = arrayOf(1, 2, 3, 5, 7, 11)

    primeNumbers.forEach({ x -> println(x) })

    println("they are equivalent")

    primeNumbers.forEach ({ println(it) })

}
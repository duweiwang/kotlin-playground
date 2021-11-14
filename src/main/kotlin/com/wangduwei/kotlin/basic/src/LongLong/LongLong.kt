package com.wangduwei.kotlin.basic.src.LongLong

class Test {
    private val total : Int
        get() = 1 + 1

    fun print() {
        println(total)
    }
}

fun main() {
    val test = Test()
    test.print()
}

package com.wangduwei.kotlin.tailrec

/**
 * 尾递归函数
 *
 * Kotlin编译器将把声明为tailrec的函数转换成循环
 */
fun main() {
    val result = factorial(4)
    println(result)//4*3*2 = 24
}

tailrec fun factorial(n: Long, accum: Long = 1): Long {
    val soFar = n * accum
    return if (n <= 1) {
        soFar
    } else {
        factorial(n - 1, soFar)
    }
}
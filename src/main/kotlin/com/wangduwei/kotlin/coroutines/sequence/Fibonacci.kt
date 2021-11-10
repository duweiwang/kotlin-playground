package com.wangduwei.kotlin.coroutines.sequence

import java.math.BigInteger

/**
 * @author 杜伟
 * @date 2021/11/5 5:53 PM
 *
 */
fun main() {
    print(fibonacci.take(10).toList())
}


val fibonacci: Sequence<BigInteger> = sequence {
    var first = 0.toBigInteger()
    var second = 1.toBigInteger()
    while (true) {
        yield(first)
        val temp = first
        first += second
        second = temp
    }
}

package com.wangduwei.kotlin.coroutines.sequence

import kotlin.random.Random

/**
 * @author 杜伟
 * @date 2021/11/5 5:56 PM
 *
 */

fun main() {
    println(randomNumbers().first())
    println(randomUniqueStrings(10).first())
}

fun randomNumbers(
    seed: Long = System.currentTimeMillis()
): Sequence<Int> = sequence {
    val random = Random(seed)
    while (true) {
        yield(random.nextInt())
    }
}

fun randomUniqueStrings(
    length: Int,
    seed: Long = System.currentTimeMillis()
): Sequence<String> = sequence {
    val random = Random(seed)
    val charPool = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    while (true) {
        val randomString = (1..length)
            .map { i -> random.nextInt(charPool.size) }
            .map(charPool::get)
            .joinToString("");
        yield(randomString)
    }
}.distinct()
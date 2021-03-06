package com.wangduwei.kotlin.coroutines.playground.exceptionhandling

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * 这种方式不能捕获异常
 */
fun main() {

    val scope = CoroutineScope(Job())
    try {
        scope.launch {
            functionThatThrowsIt()
        }
    } catch (e: Exception) {
        println("Caught: $e")
    }

    Thread.sleep(100)
}

fun functionThatThrowsIt() {
    throw RuntimeException()
}
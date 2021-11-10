package com.wangduwei.kotlin.coroutines.playground.cancellation

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 * 协程的取消：在协程的作用域内执行代码（结构化并发），对返回的job进行取消
 */
fun main() = runBlocking {

    val job = launch {//主线程
        repeat(10) { index ->
            println("${Thread.currentThread().name} operation number $index")
            try {
                delay(100)
            } catch (exception: CancellationException) {
                println("CancellationException was thrown")
                throw CancellationException()
            }
        }
    }

    delay(250)
    println("Cancelling Coroutine")
    job.cancel()
}
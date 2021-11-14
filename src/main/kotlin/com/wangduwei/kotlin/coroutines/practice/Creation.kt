package com.wangduwei.kotlin.coroutines.practice

import kotlin.coroutines.*

/**
 * 通过suspendLambda创建协程
 */
fun main() = kotlinx.coroutines.runBlocking<Unit> {
    val suspendLambda = suspend { "Hello world!" }

    val completion = object : Continuation<String> {
        override val context get() = EmptyCoroutineContext
        override fun resumeWith(result: Result<String>): Unit = println(result.getOrThrow())
    }

    val coroutine: Continuation<Unit> = suspendLambda.createCoroutine(completion)
    coroutine.resume(Unit)

    //或：
    // suspendLambda.startCoroutine(completion)
}





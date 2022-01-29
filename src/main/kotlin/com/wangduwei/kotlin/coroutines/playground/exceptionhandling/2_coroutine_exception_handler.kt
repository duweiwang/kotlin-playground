package com.wangduwei.kotlin.coroutines.playground.exceptionhandling

import com.wangduwei.kotlin.coroutines.playground.exceptionhandling.functionThatThrowsIt
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * 这种方式也不行
 */
fun main() {

    val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        println("Caught $exception in CoroutineExceptionHandler")
    }

    val scope = CoroutineScope(Job())

    scope.launch {
        launch(exceptionHandler) {
            functionThatThrowsIt()
        }
    }

    Thread.sleep(100)
}
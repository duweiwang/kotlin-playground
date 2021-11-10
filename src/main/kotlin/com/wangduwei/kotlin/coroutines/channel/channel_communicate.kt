package com.wangduwei.kotlin.coroutines.channel

import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/19 1:55 PM
 *
 */


fun main() = runBlocking {
    // given
    val channel = Channel<String>()

    // when
    launch { // coroutine1
        channel.send("Hello World!")
    }
    val result = async { // coroutine2
        channel.receive()
    }

    // assert true
    println(result.await() == "Hello World!")
}
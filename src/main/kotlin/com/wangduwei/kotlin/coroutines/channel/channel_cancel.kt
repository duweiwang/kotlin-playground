package com.wangduwei.kotlin.coroutines.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/19 1:26 PM
 *
 *
 * 以下示例：
 *
 * 如果不调用close，接受者协程会一直等待
 *
 */


fun main() = runBlocking {

    val channel = Channel<Int>()

    launch {
        println("send thread = ${Thread.currentThread().name}")
        for (x in 1..5){
            channel.send(x)
        }
        channel.close()
    }
    println("receiver thread = ${Thread.currentThread().name}")
    for (y in channel) println(y)

    println("Done!")
}
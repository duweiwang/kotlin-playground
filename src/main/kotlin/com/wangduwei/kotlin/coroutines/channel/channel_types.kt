package com.wangduwei.kotlin.coroutines.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
/**
 * @author 杜伟
 * @date 2021/9/19 2:01 PM
 *
 * channel的几种类型
 * 1、无缓存：发送者挂起，直到接受者拿走元素。接收者挂起直到生产者发送。
 * 2、缓存：通过构造函数传入buffer的大小
 * 3、无限channel：无限的缓存容量，注意可能会OOM
 * 4、可以合并的channel：最新值覆盖旧值，所以send方法不会挂起，接受者只能收到最新的值
 */

fun main() = runBlocking {



}


private suspend fun type_one() = runBlocking{
    val basket = Channel<String>()

    launch { // coroutine1
        val fruits = listOf("Apple", "Orange")
        for (fruit in fruits) {
            println("coroutine1: Sending $fruit")
            basket.send(fruit)
        }
    }

    launch { // coroutine2
        repeat(2) {
            delay(100)
            println("coroutine2: Received ${basket.receive()}")
        }
    }
    //coroutine1: Sending Apple
    //coroutine2: Received Apple
    //coroutine1: Sending Orange
    //coroutine2: Received Orange
}


private fun type_two() = runBlocking {
    val basket = Channel<String>(1)

    launch { // coroutine1
        val fruits = listOf("Apple", "Orange", "Banana")
        for (fruit in fruits) {
            println("coroutine1: Sending $fruit")
            basket.send(fruit)
        }
    }

    launch { // coroutine2
        repeat(3) {
            delay(100)
            println("coroutine2: Received ${basket.receive()}")
        }
    }
    //coroutine1: Sending Apple
    //coroutine1: Sending Orange
    //coroutine2: Received Apple
    //coroutine1: Sending Banana
    //coroutine2: Received Orange
    //coroutine2: Received Banana
}



private fun type_three() = runBlocking {

    val channel = Channel<Int>(UNLIMITED)

    launch { // coroutine1
        repeat(100) {
            println("coroutine1: Sending $it")
            channel.send(it)
        }
    }

    launch { // coroutine2
        repeat(100) {
            println("coroutine2: Received ${channel.receive()}")
        }
    }
    //coroutine1: Sending 0
    //coroutine1: Sending 1
    //
    //...
    //
    //coroutine1: Sending 98
    //coroutine1: Sending 99
    //coroutine2: Received 0
    //coroutine2: Received 1
    //
    //...
    //
    //coroutine2: Received 98
    //coroutine2: Received 99


}



private fun type_four() = runBlocking {

    val basket = Channel<String>(1)

    launch { // coroutine1
        val fruits = listOf("Apple", "Orange", "Banana")
        for (fruit in fruits) {
            println("coroutine1: Sending $fruit")
            basket.send(fruit)
        }
    }

    launch { // coroutine2
        repeat(3) {
            delay(100)
            println("coroutine2: Received ${basket.receive()}")
        }
    }

    //coroutine1: Sending Apple
    //coroutine1: Sending Orange
    //coroutine1: Sending Banana
    //coroutine2: Received Banana

}
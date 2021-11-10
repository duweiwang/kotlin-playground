package com.wangduwei.kotlin.coroutines.channel.consumer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/19 2:32 PM
 *
 * One Consumer Consuming From One Producer
 *
 */


fun main()= runBlocking {
    val fruitChannel = produceFruits()
    for (fruit in fruitChannel) {
        println(fruit)
    }

}
fun CoroutineScope.produceFruits(): ReceiveChannel<String> = produce {
    val fruits = listOf("Apple", "Orange", "Apple")
    for (fruit in fruits) send(fruit)
}
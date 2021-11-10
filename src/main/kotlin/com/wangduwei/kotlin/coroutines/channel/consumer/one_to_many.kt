package com.wangduwei.kotlin.coroutines.channel.consumer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/19 2:34 PM
 *
 * Several Consumers Consuming From One Producer

 *
 */


fun main() = runBlocking {
    val pizzaOrders = producePizzaOrders()
    repeat(3) {
        pizzaOrderProcessor(it + 1, pizzaOrders)
    }

    delay(1000)
    pizzaOrders.cancel()
}

fun CoroutineScope.producePizzaOrders(): ReceiveChannel<String> = produce {
    var x = 1
    while (true) {
        send("Pizza Order No. ${x++}")
        delay(100)
    }
}

fun CoroutineScope.pizzaOrderProcessor(id: Int, orders: ReceiveChannel<String>) = launch {
    for (order in orders) {
        println("Processor #$id is processing $order")
    }
}
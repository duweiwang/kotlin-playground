package com.wangduwei.kotlin.coroutines.channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/19 2:43 PM
 *
 *
 * 制作披萨的过程：烘烤-》上料
 * 进行分解，降低复杂度
 *
 */
data class PizzaOrder(val orderNumber:Int,val orderStatus:Int = 0)
private const val BAKED = 1
private const val TOPPED = 2

//烘烤
fun CoroutineScope.baking(orders: ReceiveChannel<PizzaOrder>) = produce {
    for (order in orders) {
        delay(200)
        println("Baking ${order.orderNumber}")
        send(order.copy(orderStatus = BAKED))
    }
}

fun CoroutineScope.topping(orders: ReceiveChannel<PizzaOrder>) = produce {
    for (order in orders) {
        delay(50)
        println("Topping ${order.orderNumber}")
        send(order.copy(orderStatus = TOPPED))
    }
}

fun CoroutineScope.produceOrders(count: Int) = produce {
    repeat(count) {
        delay(50)
        send(PizzaOrder(orderNumber = it + 1))
    }
}


fun main() = runBlocking {
    val orders = produceOrders(3)

    val readyOrders = topping(baking(orders))

    for (order in readyOrders) {
        println("Serving ${order.orderNumber}")
    }

    delay(3000)
    coroutineContext.cancelChildren()
}
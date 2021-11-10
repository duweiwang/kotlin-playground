package com.wangduwei.kotlin.coroutines.channel

import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.time.Duration
import kotlin.random.Random

/**
 * @author 杜伟
 * @date 2021/9/19 2:51 PM
 *
 * kotlin的定时任务，一定时间间隔执行一段逻辑
 *
 */

fun stockPrice(stock: String): Double {
    println("Fetching stock price of $stock")
    return Random.nextDouble(2.0, 3.0)
}

fun main() = runBlocking {
    val tickerChannel = ticker(Duration.ofSeconds(5).toMillis())

    repeat(3) {
        tickerChannel.receive()
        println(stockPrice("TESLA"))
    }

    delay(Duration.ofSeconds(11).toMillis())
    tickerChannel.cancel()
}
package com.wangduwei.kotlin.coroutines.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope

/**
 * @author 杜伟
 * @date 2021/9/20 9:08 AM
 *
 */

val channel = Channel<Int>()
// 接受消息
suspend fun receiveEvent() {
    coroutineScope {
        while (!channel.isClosedForReceive) {

            // receive()方法异步获取元素，如果缓冲区是空，receive() 调用者将被挂起，直到一个新值被发送到缓冲区
            // receive() 是一个挂起函数，用于同步发送方和接收方的一种机制
            channel.receive()

            // poll()方法同步获取一个元素，如果缓冲区是空的，则返回null
            // channel.poll()
        }
    }
}

// 发送消息
suspend fun postEvent() {
    coroutineScope {
        if (!channel.isClosedForSend) {
            (1..10).forEach {

                // 如果缓冲区没有满，则立即添加元素，
                // 如果缓冲区满了调用者会被挂起
                // send() 是一个挂起函数，用于同步发送方和接收方的一种机制
                channel.send(it)

                // offer()：如果缓冲区存在并且没有满立即向缓冲区添加一个元素
                // 如果添加成功会返回true, 失败会返回 false
                // channel.offer(it)
            }
        }
    }
}

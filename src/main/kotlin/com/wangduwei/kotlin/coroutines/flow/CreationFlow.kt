package com.wangduwei.kotlin.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/1/5 下午5:29
 *
 * 创建flow：
 * 1、flowOf
 * 2、xxx.asFlow
 *
 */
fun main() = runBlocking {
    flow {
        for (i in 1..5) {
            delay(100)
            emit(i)
        }
    }.collect {
        println(it)
    }

    flowOf(1, 2, 3, 4, 5)
            .onEach {
                delay(100)
            }
            .collect {
                println(it)
            }


    listOf(1, 2, 3, 4, 5).asFlow()
            .onEach {
                delay(100)
            }.collect {
                println(it)
            }

    channelFlow {
        for (i in 1..5) {
            delay(100)
            send(i)
        }
    }.collect {
        println(it)
    }

}

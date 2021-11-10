package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/23 8:56 PM
 *
 *
 *  //将flow的多个任务分配到不同的协程中去执行，加快执行的速度。
 */

fun main() = runBlocking {

    val flow1 = flow {
        delay(2000)  // 假设耗时任务
        emit(1)      // 释放值
        delay(2000)
        emit(2)
        delay(2000)
        emit(3)
        delay(2000)
        emit(4)
    }

    flow1.collect { value ->
        println(value)
        delay(4000)
    }

    // 结果
    // 2020-11-16 13:48:37.144 24060-24116/com.johnny.flowdemo I/System.out: 1
    // 2020-11-16 13:48:43.150 24060-24116/com.johnny.flowdemo I/System.out: 2
    // 2020-11-16 13:48:49.160 24060-24116/com.johnny.flowdemo I/System.out: 3
    // 2020-11-16 13:48:55.166 24060-24116/com.johnny.flowdemo I/System.out: 4
    // 解释：
    // 4个耗时操作每个2000毫秒，加上collect的4000毫秒，所以每个值的时间间隔是6000毫秒。

    val flow2 = flow {
        delay(2000)  // 假设耗时任务
        emit(1)      // 释放值
        delay(2000)
        emit(2)
        delay(2000)
        emit(3)
        delay(2000)
        emit(4)
    }.buffer()

    flow2.collect { value ->
        println(value)
        delay(4000)
    }

    // 结果
    // 2020-11-16 13:51:11.290 24253-24299/com.johnny.flowdemo I/System.out: 1
    // 2020-11-16 13:51:15.293 24253-24299/com.johnny.flowdemo I/System.out: 2
    // 2020-11-16 13:51:19.297 24253-24300/com.johnny.flowdemo I/System.out: 3
    // 2020-11-16 13:51:23.301 24253-24300/com.johnny.flowdemo I/System.out: 4

    // 解释：
    // 4个耗时操作被分配到了不同的协程中执行，总共耗时了大约2000毫秒。collect收到的4个值差不多同时，所以每个值依次收到的时间间隔是4000毫秒。


}
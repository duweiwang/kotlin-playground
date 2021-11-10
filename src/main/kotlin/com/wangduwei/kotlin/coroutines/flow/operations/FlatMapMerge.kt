package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/23 8:59 PM
 *
 *
 *  /**
 * 将原始的Flow<T>通过[transform]转换成Flow<Flow<T>>，然后将Flow<Flow<T>>释放的Flow<T>其中释放的值一个个释放。

它与flatMapConcat的区别是：Flow<Flow<T>>释放的Flow<T>其中释放的值没有顺序性，谁先产生谁先释放。
*/
 *
 */

fun main() = runBlocking {

    flow {
        delay(1000)
        emit(1)
        delay(1000)
        emit(2)
        delay(1000)
        emit(3)
        delay(1000)
        emit(4)
    }.flatMapMerge {
        flow {
            emit("$it 产生第一个flow值")
            delay(2500)
            emit("$it 产生第二个flow值")
        }
    }.collect { value ->
        println(value)
    }

    // 结果
    // I/System.out: 1 产生第一个flow值
    // I/System.out: 2 产生第一个flow值
    // I/System.out: 3 产生第一个flow值
    // I/System.out: 1 产生第二个flow值
    // I/System.out: 4 产生第一个flow值
    // I/System.out: 2 产生第二个flow值
    // I/System.out: 3 产生第二个flow值
    // I/System.out: 4 产生第二个flow值

    // 解释：
    // 原始Flow<Int>首先释放1, 第二个Flow<Flow<Int>> 释放 1产生第一个flow值，
    // 但是 1产生第二个flow值是3500毫秒才释放，2 产生第一个flow值 是2000毫秒释放，
    // 3 产生第一个flow值 是3000毫秒释放，3500毫秒时刻才是 1产生第二个flow值 的释放
}
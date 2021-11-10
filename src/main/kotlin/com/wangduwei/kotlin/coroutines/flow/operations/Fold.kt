package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/23 9:12 PM
 *
 * 和scan类似，有一个初始值，但是只计算最后的结果。
 *
 */

fun main() = runBlocking {
    val flow1 = flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }
    println(flow1.fold(100) { acc, value -> acc * value })

// 结果：2400
// 解释：计算最后的结果，100 * 1 * 2 * 3 * 4 = 2400
}
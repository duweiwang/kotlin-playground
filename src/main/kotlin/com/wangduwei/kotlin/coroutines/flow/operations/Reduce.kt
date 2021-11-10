package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/23 9:13 PM
 *
 * 和runningReduce类似，但是只计算最后的结果。
 *
 */


fun main() = runBlocking {
    val flow1 = flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }
    println(flow1.reduce { acc, value -> acc * value })

// 结果：24
// 解释：计算最后的结果，1 * 2 * 3 * 4 = 24
}
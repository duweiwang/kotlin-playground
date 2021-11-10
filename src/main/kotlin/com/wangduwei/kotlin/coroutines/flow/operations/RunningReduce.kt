package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.runningReduce

/**
 * @author 杜伟
 * @date 2021/9/23 9:01 PM
 *
 *
 * 和scan类似，但是没有初始值，最开始是它本身
 *
 */


fun main() {
    flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.runningReduce { acc, value ->
        acc * value
    }

    // 结果: 1 2 6 24
    // 解释：
    // 1  1
    // 2  1 * 2 = 2
    // 3  2 * 3 = 6
    // 4  6 * 4 = 24
}
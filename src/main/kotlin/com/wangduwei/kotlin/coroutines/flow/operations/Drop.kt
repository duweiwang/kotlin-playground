package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.flow

/**
 * @author 杜伟
 * @date 2021/9/23 8:52 PM
 *
 * 忽略最开始的[count]个值
 *
 */

fun main() {
     flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.drop(2)

// 结果：3 4
// 解释：
// 最开始释放的两个值(1,2)被忽略了

}


package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take

/**
 * @author 杜伟
 * @date 2021/9/23 8:54 PM
 *
 * 只释放前面[count]个值
 *
 */

fun main() {
   flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.take(2)

    // 结果：1 2
    // 解释：
    // 前面两个值被释放

}
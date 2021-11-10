package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

/**
 * @author 杜伟
 * @date 2021/9/23 8:38 PM
 *
 *
 * 第一个值被释放之前被执行
 */

fun main() {

    flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.onStart { emit(1000) }

    // 结果：1000 1 2 3 4
    // 解释：
    // 第一个值1被释放的时候调用了emit(1000), 所以1000在1之前被释放

}
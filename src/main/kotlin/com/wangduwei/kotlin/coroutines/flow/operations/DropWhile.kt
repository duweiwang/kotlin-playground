package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/23 8:53 PM
 *
 * 判断第一个值如果满足(T) -> Boolean这个条件就忽略
 *
 */


fun main() {


     flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.dropWhile {
        it % 2 == 0
    }

    // 结果：1 2 3 4
    // 解释：
    // 第一个值不是偶数，所以1被释放

     flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.dropWhile {
        it % 2 != 0
    }

    // 结果：2 3 4
    // 解释：
    // 第一个值是偶数，所以1被忽略
}
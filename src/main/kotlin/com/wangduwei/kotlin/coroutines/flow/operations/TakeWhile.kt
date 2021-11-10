package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/23 8:54 PM
 *
 * //判断第一个值如果满足(T) -> Boolean这个条件就释放
 */

fun main()  {


     flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.takeWhile { it % 2 != 0 }

    // 结果：1
    // 解释：
    // 第一个值满足是奇数条件

    flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.takeWhile { it % 2 == 0 }

    // 结果：无
    // 解释：
    // 第一个值不满足是奇数条件
}
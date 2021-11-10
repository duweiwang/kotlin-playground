package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.scan

/**
 * @author 杜伟
 * @date 2021/9/23 9:00 PM
 *有一个初始值，然后每个值都和初始值进行运算，然后这个值作为后一个值的初始值
 */

fun main() {

     flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.scan(100) { acc, value ->
        acc * value
    }

    // 结果: 100 100 200 600 2400
    // 解释：
    // 初始值 100
    // 1  100 * 1 = 100
    // 2  100 * 2 = 200
    // 3  200 * 3 = 600
    // 4  600 * 4 = 2400
}
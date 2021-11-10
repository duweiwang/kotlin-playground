package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform

/**
 * @author 杜伟
 * @date 2021/9/23 8:37 PM
 *
 * 对每个值进行转换
 *
 */


fun main() {

    flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.transform {
        if (it % 2 == 0) {
            emit(it * it)
        }
    }

    // 结果：4 16
    // 解释：
    // 1 不是偶数，被忽略
    // 2 是偶数，2的平方4
    // 3 不是偶数，被忽略
    // 4 是偶数，4的平方16
}
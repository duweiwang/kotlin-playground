package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/23 9:10 PM
 *
 */


fun main() = runBlocking {
    flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.map {
        check(it <= 1) { "$it 大于1" }
        it
    }.catch { e -> println("Caught $e") }
        .collect()

// 结果：
// Caught java.lang.IllegalStateException: 2 大于1
}
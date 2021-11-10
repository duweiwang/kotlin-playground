package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flattenConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/23 8:58 PM
 *
//和flatMapConcat类似，只是少了一步Map操作。
 */


fun main() {

     flow {
        delay(1000)
        emit(flow {
            emit("1 产生第一个flow值")
            delay(2000)
            emit("1 产生第二个flow值")
        })
        delay(1000)
        emit(flow {
            emit("2 产生第一个flow值")
            delay(2000)
            emit("3 产生第二个flow值")
        })
        delay(1000)
        emit(flow {
            emit("3 产生第一个flow值")
            delay(2000)
            emit("3 产生第二个flow值")
        })
        delay(1000)
        emit(flow {
            emit("4 产生第一个flow值")
            delay(2500)
            emit("4 产生第二个flow值")
        })
    }.flattenConcat()

    // 结果
    // I/System.out: 1 产生第一个flow值
    // I/System.out: 1 产生第二个flow值
    // I/System.out: 2 产生第一个flow值
    // I/System.out: 2 产生第二个flow值
    // I/System.out: 3 产生第一个flow值
    // I/System.out: 3 产生第二个flow值
    // I/System.out: 4 产生第一个flow值
    // I/System.out: 4 产生第二个flow值

}
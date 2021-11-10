package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * @author 杜伟
 * @date 2021/9/23 8:55 PM
 *
 */


fun main() = runBlocking {

    withContext(Dispatchers.Main) {
        flow {
            println("Thread name1 = ${Thread.currentThread().name}")
            emit(1)
            emit(2)
            emit(3)
            emit(4)
        }
            .map {
                println("Thread name2 = ${Thread.currentThread().name}")
                it * it
            }
            .filter {
                println("Thread name3 = ${Thread.currentThread().name}")
                it > 9
            }
            .flowOn(Dispatchers.IO)
            .collect { value ->
                println("Thread name4 = ${Thread.currentThread().name}")
                println(value)
            }
    }


    // 结果：
    // Thread name1 = DefaultDispatcher-worker-1
    // Thread name2 = DefaultDispatcher-worker-1
    // Thread name3 = DefaultDispatcher-worker-1
    // Thread name2 = DefaultDispatcher-worker-1
    // Thread name3 = DefaultDispatcher-worker-1
    // Thread name2 = DefaultDispatcher-worker-1
    // Thread name3 = DefaultDispatcher-worker-1
    // Thread name2 = DefaultDispatcher-worker-1
    // Thread name3 = DefaultDispatcher-worker-1
    // Thread name4 = main
    // 16
    // 解释：
    // flowOn(Dispatchers.IO)之前的flow，map，filter都是在Dispatchers.IO上执行
    // flowOn(Dispatchers.IO)之后的collect则由withContext(Dispatchers.Main)决定


}
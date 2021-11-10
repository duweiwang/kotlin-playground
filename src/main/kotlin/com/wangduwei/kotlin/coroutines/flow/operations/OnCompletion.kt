package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion

/**
 * @author 杜伟
 * @date 2021/9/23 8:39 PM
 *
 * 最后一个值释放完成之后被执行
 *
 */

fun main(){

     flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.onCompletion { emit(1000) }

    // 结果：1 2 3 4 1000
    // 解释：
    // 第一个值4被释放的时候调用了emit(1000), 所以1000在4之后被释放

}
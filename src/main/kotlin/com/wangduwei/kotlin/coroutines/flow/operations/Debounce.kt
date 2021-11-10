package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow

/**
 * @author 杜伟
 * @date 2021/9/23 8:28 PM
 *
 * 1、debounce
 * 1.1 如果两个相邻的值生产出来的时间间隔超过了[timeout]毫秒，就忽过滤掉前一个值
 * 1.2 最后一个值不受影响，总是会被释放emit。
 */

fun main() {
     flow {
        emit(1)
        delay(3000)
        emit(2)
        delay(1000)
        emit(3)
        delay(1000)
        emit(4)
    }.debounce(2000)
}


// 结果：1 4
// 解释：
//  2和1的间隔大于2000，1被释放
//  3和2的间隔小于2000, 2被忽略
//  4和3的间隔小于2000, 3被忽略
//  4是最后一个值不受timeout值的影响, 4被释放
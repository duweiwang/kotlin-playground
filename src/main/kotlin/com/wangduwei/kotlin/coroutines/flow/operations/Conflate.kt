package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/23 8:57 PM
 *
 *
 * //如果值的生产速度大于值的消耗速度，就忽略掉中间未来得及处理的值，只处理最新的值。
 */

fun main() = runBlocking {

    val flow1 = flow {
        delay(2000)
        emit(1)
        delay(2000)
        emit(2)
        delay(2000)
        emit(3)
        delay(2000)
        emit(4)
    }.conflate()

    flow1.collect { value ->
        println(value)
        delay(5000)
    }

    // 结果: 1 3 4
    // 解释：
    // 2000毫秒后生产了1这个值，交由collect执行，花费了5000毫秒，当1这个值执行collect完成后已经经过了7000毫秒。
    // 这7000毫秒中，生产了2，但是collect还没执行完成又生产了3，所以7000毫秒以后会直接执行3的collect方法，忽略了2这个值
    // collect执行完3后，还有一个4，继续执行。

}
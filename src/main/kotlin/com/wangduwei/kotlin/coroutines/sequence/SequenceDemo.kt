package com.wangduwei.kotlin.coroutines.sequence

/**
 * @author 杜伟
 * @date 2021/11/5 3:42 PM
 *
 * sequence 和 list 的区别
 * 操作符对其的影响：
 * 1、sequence操作终止前不进行计算，只进行装饰
 * 2、list对于每一个操作符都执行计算
 *
 */
fun main() {

    val seq = sequenceOf(1, 2, 3)
    val filtered = seq.filter { print("f$it "); it % 2 == 1 }
    /**
     * 只是对原来sequence做了装饰，并不执行计算
     */
    println(filtered)  // FilteringSequence@...

    val asList = filtered.toList()
// f1 f2 f3
    println(asList) // [1, 3]

    ////////////////////////////////////////////////////////////////////////
    val list = listOf(1, 2, 3)
    val listFiltered = list
        .filter { print("f$it "); it % 2 == 1 }
// f1 f2 f3
    println(listFiltered) // [1, 3]

}




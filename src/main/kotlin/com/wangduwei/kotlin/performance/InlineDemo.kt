package com.wangduwei.kotlin.performance

import kotlin.system.measureTimeMillis

/**
 * @author 杜伟
 * @date 2021/11/8 10:25 PM
 *
 * 本代码演示内联函数和非内联函数的性能差异。
 * 1、非内联函数会生成一个额外的对象，我们应该尽量避免创建不必要的对象，查看反编译的java代码
 *
 */
fun main(){
    val cost = measureTimeMillis {
        //这里是内联函数，会被展开，不会生成对象
        nothingInline(object : Blackhole {
            override fun consume(i: Int) {}
        })
    }
    println("cost = $cost")//8
    //这里不是内联函数，会生成一个Function1的对象
    val cost2 = measureTimeMillis {
        nothingNoninline(object : Blackhole {
            override fun consume(i: Int) {}
        })
    }

    println("cost = $cost2")//16
}

inline fun repeat(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(index)
    }
}

fun repeatNoinline(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(index)
    }
}

interface Blackhole{
    fun consume(i:Int)
}

fun nothingInline(blackhole: Blackhole) {
    repeat(100_000_000) {
        blackhole.consume(it)
    }
}

fun nothingNoninline(blackhole: Blackhole) {
    repeatNoinline(100_000_000) {
        blackhole.consume(it)
    }
}
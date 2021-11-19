package com.wangduwei.kotlin.operator_overloading


/**
 * 一元操作符："-" 、"+" 、"!"
 *
 * 下面演示以拓展函数的形式重载操作符
 */

fun main() {

    val point = Point(10, 20)
    val bPoint = BooleanPoint(valueA = true, valueB = true)

    println(-point)
    println(+point)
    println(!bPoint)

    //Point(x=9, y=19)
    //Point(x=11, y=21)
    //BooleanPoint(valueA=false, valueB=false)
}

data class Point(val x: Int, val y: Int)

data class BooleanPoint(val valueA: Boolean,
                        val valueB: Boolean)

//减号操作符对原对象属性进行减一操作
operator fun Point.unaryMinus() = Point(x - 1, y - 1)
operator fun Point.unaryPlus() = Point(x + 1, y + 1)


//对原对象所有属性进行取反操作
operator fun BooleanPoint.not() = BooleanPoint(!valueA, !valueB)
package com.wangduwei.kotlin.lambda

/**
 * <p>
 *     show how lambda works
 * </p>
 * @auther:duwei
 * @date:2019/2/15
 */
class LambdaTest {
    var mName: String? = "asd"

    var lambda = { x: Int, y: Int ->
        x + y
//        this.mName//this代表外部类
    }

    fun main(args: Array<String>) {
        lambda(1, 2)

        printSum(lambda)
    }

    fun printSum(name: (Int, Int) -> Int) {
        val value = name(1, 2)
    }

}
package com.wangduwei.kotlin.collections

class Operator {

    /**
     * filter操作->过滤
     */
    fun filterTest() {
        val list = listOf(1, 2, 3, 4)
        var result = list.filter {
            it % 2 == 0
        }
        println(result)
    }

    /**
     * map操作->
     */
    fun mapTest() {
        val list = listOf(1, 2, 3, 4)
        var result = list.map {
            it * it
        }
        println(result)

    }


}
package com.wangduwei.kotlin.collections.list

import java.util.*


/**
 * 在kotlin中使用list
 */
fun main(){
    val list = arrayListOf(1, 2, 3)
    val emptyList = emptyList<String>()
    val numList = listOf("one", "two")
    val mutableList = mutableListOf("one", "two")
    val linkedList = LinkedList<String>(listOf("one", "two", "three"))
    // or MutableList if you want to change its content later
    val doubled = List(3, { it * 2 })

    for (p in list.indices) {
        print ("${list[p]}, ")
    }

    for (p in list) {
        print ("$p, ")
    }
}
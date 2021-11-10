package com.wangduwei.kotlin.collections

import java.util.*
import kotlin.collections.HashSet

/**
 * 构造集合
 *
 * @author : wangduwei
 * @date : 2020/4/25
 * @description :
 */
class BasicCollectionConstruct {

    val numberSet = setOf<String>("one", "two")
    val numList = listOf<String>("one", "two")
    val numberMap = mapOf<String, Int>("key1" to 1)

    val mutableList = mutableListOf<String>("one", "two")
    val mutableSet = mutableSetOf<String>()
    val mutableMap = mutableMapOf<String, String>("one" to "one")

    val numbersMap = mutableMapOf<String, String>().apply { this["one"] = "1"; this["two"] = "2" }


    //构造空集合--------------------------
    val emptyList = emptyList<String>()
    val emptySet = emptySet<String>()
    val emptyMap = emptyMap<String, String>()


    //构造时做一些初始化
    val doubled = List(3, { it * 2 })  // or MutableList if you want to change its content later

    val linkedList = LinkedList<String>(listOf("one", "two", "three"))
    val presizedSet = HashSet<Int>(32)

}
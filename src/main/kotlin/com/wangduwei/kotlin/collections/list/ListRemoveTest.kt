package com.wangduwei.kotlin.collections.list

/**
 * 修改第一个集合的元素，第二个集合的元素会被影响
 */
fun main(){
    class Obj(var v:Int)

    val list1 = mutableListOf<Obj>()
    val obj = Obj(1)
    list1.add(obj)

    val list2 = mutableListOf<Obj>()
    list2.addAll(list1)

    val list3 = list1.toMutableList()

    list1[0].v = 2

    println("size="+list2[0].v)


    println("value = ${list3[0].v}")
}
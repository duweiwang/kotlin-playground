package com.wangduwei.kotlin.collections

/**
 * @author : wangduwei
 * @date : 2020/4/25
 * @description :
 */
class Iterator {

    fun test(){
        val numbers = listOf("one", "two", "three", "four")

        //1-----
        val numbersIterator = numbers.iterator()
        while (numbersIterator.hasNext()) {
            println(numbersIterator.next())
        }
//2----
        for (item in numbers) {
            println(item)
        }
//3----
        numbers.forEach {
            println(it)
        }
    }



    //使用ListIterator前后迭代
    fun test2(){
        val numbers = listOf("one", "two", "three", "four")

        val listIterator = numbers.listIterator()
        while (listIterator.hasNext()) listIterator.next()

        println("Iterating backwards:")

        while (listIterator.hasPrevious()) {
            print("Index: ${listIterator.previousIndex()}")
            println(", value: ${listIterator.previous()}")
        }
    }

}
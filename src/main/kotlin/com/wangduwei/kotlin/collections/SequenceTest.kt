package com.wangduwei.kotlin.collections

/**
 * Sequence操作
 */

fun  main(){
    SequenceTest.test1()
    SequenceTest.test2()
    SequenceTest.test3()
}
object SequenceTest {

    data class Obj(val data:Int)

    fun test1() {
        val objList = initList()

        val start = System.currentTimeMillis()
        val newList = objList.filterIsInstance<Obj>().filter {
            it.data > 0
        }.map {
            it.data
        }.toMutableList()
        println(newList.size)

        val end = System.currentTimeMillis() - start
        println("test1 = $end")
    }

    fun test2() {
       val objList = initList()

        val start = System.currentTimeMillis()
        val newList = objList.asSequence().filterIsInstance<Obj>().filter {
            it.data > 0
        }.map {
            it.data
        }.toMutableList()
        println(newList.size)
        val end = System.currentTimeMillis() - start
        println("test2 = $end")
    }

    fun test3() {
        val objList = initList()

        val start = System.currentTimeMillis()
        val newList = mutableListOf<Int>()
        objList.forEach {
            if (it is Obj && it.data > 0){
                newList.add(it.data)
            }
        }
        println(newList.size)
        val end = System.currentTimeMillis() - start
        println("test3 = $end")
    }

    private fun initList(): List<Any> {
        val objList = mutableListOf<Any>()

        for (i in 0..1000){
            objList.add(Obj(i))
        }
        return objList
    }


}
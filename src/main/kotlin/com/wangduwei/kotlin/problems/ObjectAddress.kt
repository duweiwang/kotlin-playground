package com.wangduwei.kotlin.problems

import java.util.concurrent.Executors

/**
 * @desc:
 * kotlin 如何打印对象的地址
 * @auther:duwei
 * @date:2019/2/13
 */
class ObjectAddress {

    fun objectAdress(){
        val int = System.identityHashCode(this)
        println("address = $int")
    }

}
fun main(){
    val obj = ObjectAddress()
    val runnable = Runnable{
        obj.objectAdress()
    }

    val executors = Executors.newFixedThreadPool(3)
    executors.execute(runnable)
    executors.execute(runnable)
    executors.execute(runnable)
}
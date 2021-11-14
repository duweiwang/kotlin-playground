package com.wangduwei.kotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

/**
 * @desc:
 * kotlin 如何打印对象的地址
 * @auther:duwei
 * @date:2019/2/13
 */
class MainClass {

    fun objectAdress(){
        val int = System.identityHashCode(this)
        println("address = $int")
    }

}
fun main(){
    val obj = MainClass()
    val runnable = Runnable{
        obj.objectAdress()
    }

    val executors = Executors.newFixedThreadPool(3)
    executors.execute(runnable)
    executors.execute(runnable)
    executors.execute(runnable)
}
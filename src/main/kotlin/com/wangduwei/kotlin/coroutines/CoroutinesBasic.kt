package com.wangduwei.kotlin.coroutines

import kotlinx.coroutines.*

/**
 * @author : wangduwei
 * @date : 2020/4/22
 * @description :
 */
class CoroutinesBasic {

    fun main(): Unit {
        //协程的生命周期同应用
        GlobalScope.launch {
            //启动协程
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        Thread.sleep(2000L)
    }
/*
    fun main2(): Unit {
        thread {
        //delay是一个挂起函数，不堵塞线程
            delay(1000L)//报错：Suspend functions are only allowed to be called from a coroutine or another suspend function
            println("World!")
        }
        println("Hello,")
        Thread.sleep(2000L)
    }

 */

    //delay{}是非堵塞的，Thread.sleep是堵塞的，混用的话就不知道到底谁谁堵塞的了

    //使用runBlocking{}
    fun main3() {
        GlobalScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        runBlocking {
            //堵塞-等待里面非堵塞的delay执行完成
            delay(2000L)
        }
    }

    //更常规的写法是这样的
    fun main4() = runBlocking<Unit> {
        //一个格式良好的主函数在Kotlin中必须返回Unit。
        GlobalScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        delay(2000L)
    }


    //暂停一段时间等待其他协程完成任务很傻，

    suspend fun main5() {
        val job = GlobalScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        //报错：Suspend functions are only allowed to be called from a coroutine or another suspend function
        job.join()//等待子协程完成
    }


    //在GlobalScope中启动线程需要维护资源管理和释放等问题，换一个Scope
    fun main6() = runBlocking {
        // this: 现在处于CoroutineScope中
        launch {
            // launch a new coroutine in the scope of runBlocking
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }


    //-------------runBlocking and coroutineScope
    //这两个函数看起来都是等待代码块执行完，其实不是的，runBlocking堵塞当前线程
    //coroutineScope只是挂起，释放底层线程对象
    fun main7() = runBlocking { // this: CoroutineScope
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope { // Creates a coroutine scope
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // This line will be printed before the nested launch
        }

        println("Coroutine scope is over") // This line is not printed until the nested launch completes
    }

}
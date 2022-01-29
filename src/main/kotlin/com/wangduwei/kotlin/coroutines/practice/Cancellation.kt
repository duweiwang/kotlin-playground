package com.wangduwei.kotlin.coroutines.practice

import kotlinx.coroutines.*

/**
 * 所有的挂起函数都是可取消的，取消协程的时候抛出CancellationException
 */
fun main() = runBlocking{
//取消一个常规任务
//    cancelJob()

//取消循环任务，错误的方式
//    cancelWithTask()

//正确的取消方式
//    cancelWithTaskWorks()

//取消时资源回收
//    cancelWithRecycle()

//    取消后调用挂起函数
    cancelThenCallSuspendFun()
}


/**
 * 此代码调用[job.cancel()]后马上就不执行了
 */
suspend fun cancelJob() {
    val job = GlobalScope.launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
        delay(1300L)
    }
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    println("main: Now I can quit.")

//   job.cancelAndJoin()//有这样一个拓展函数可以使用
}

/**
 * 如果一个协程在执行计算的时候没有检查取消状态，他就不能被取消像下面这样
 *
 * 此代码调用了cancel但是还是会输出几次
 */
suspend fun cancelWithTask() {
    val startTime = System.currentTimeMillis()
    val job = GlobalScope.launch (Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) { // computation loop, just wastes CPU
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: 主线程退出")
}


//两种方式实现取消
//1、周期性的调用挂起函数检查，yield函数就是这样
//2、检查取消状态
suspend fun cancelWithTaskWorks() {
    val startTime = System.currentTimeMillis()
    val job = GlobalScope.launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // cancellable computation loop
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}


//-------------------------------------
//资源关闭
//取消抛出异常，try住，在finally回收资源
/**
 * 取消的时候做一些资源回收
 */
suspend fun cancelWithRecycle() {
    val job = GlobalScope.launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }catch (e:Exception){
          if (e is CancellationException){
              println("job: It's CancellationException")
          }
        } finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}


/**
 * 在finally里不能调用挂起函数，因为协程已经取消了，但是极端情况下也能实现
 */
suspend fun cancelThenCallSuspendFun(){
    val job = GlobalScope.launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}






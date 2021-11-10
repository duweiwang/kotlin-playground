package com.wangduwei.kotlin.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * @author : wangduwei
 * @date : 2020/4/25
 * @description :
 */
class CoroutinesBasic3 {
    //协程上下文
    fun main() = runBlocking<Unit> {
        launch {
            // context of the parent, main runBlocking coroutine
            println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined) {
            // not confined -- will work with main thread
            println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
        }
        //Default和无参数情况一样，使用共享的后台线程池
        launch(Dispatchers.Default) {
            // will get dispatched to DefaultDispatcher
            println("Default               : I'm working in thread ${Thread.currentThread().name}")
        }
        //专用的上下文比较耗资源，记得调用close或者重用
        launch(newSingleThreadContext("MyOwnThread")) {
            // will get its own new thread
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }
    }
}
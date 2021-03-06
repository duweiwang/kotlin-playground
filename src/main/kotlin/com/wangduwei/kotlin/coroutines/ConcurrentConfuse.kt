package com.wangduwei.kotlin.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * @author 杜伟
 * @date 2021/11/1 10:15 AM
 *
 * 并发逻辑的易错点
 *
 */
fun main() = runBlocking {
//    val cost1 = measureTimeMillis {
//        ConcurrentConfuse().test()
//    }
//    println("cost1=${cost1}")//cost1=6031
//
//    val cost2 = measureTimeMillis {
//        ConcurrentConfuse().test2()
//    }
//    println("cost2=${cost2}")//cost1=3007
//
//    val cost3 = measureTimeMillis {
//        ConcurrentConfuse().test3()
//    }
//    println("cost3=${cost3}")//cost1=3007

    val cost4 = measureTimeMillis {
        ConcurrentConfuse().test4()
    }
    println("cost4=${cost4}")//cost1=3007
}
class ConcurrentConfuse {
    /**
     * 不要在async后面直接调用await，这种方式不会并发
     */
    suspend fun test(){
        coroutineScope {
            val def1 = async {
                delay(3000)
            }.await()
            val def2 = async {
                delay(3000)
            }.await()
        }
    }


    /**
     * 写完async后再调用await，这样是并发的
     */
    suspend fun test2(){
        coroutineScope {
            val def1 = async {
                delay(3000)
            }
            val def2 = async {
                delay(3000)
            }
            def1.await()
            def2.await()
        }
    }


    /**
     * 这种方式也不是并发的
     */
    suspend fun test3() {
        coroutineScope {
            val def1 = async(start = CoroutineStart.LAZY) {
                delay(3000)
            }
            val def2 = async(start = CoroutineStart.LAZY) {
                delay(3000)
            }
            def1.await()
            def2.await()
        }
    }

    /**
     *  def3 thread = DefaultDispatcher-worker-3
     *  def1 thread = DefaultDispatcher-worker-2
     *  def2 thread = DefaultDispatcher-worker-5
     *  cost4=2036
     */
    suspend fun test4() = withContext(Dispatchers.IO){
        coroutineScope {
            val def3 = async {
                println("def3 thread = ${Thread.currentThread().name}")
                delay(2000)
            }

            coroutineScope {
                val def1 = async {
                    println("def1 thread = ${Thread.currentThread().name}")
                    delay(2000)
                }
                val def2 = async {
                    println("def2 thread = ${Thread.currentThread().name}")
                    delay(2000)
                }
                def1.await()
                def2.await()
            }
            def3.await()
        }
    }

}
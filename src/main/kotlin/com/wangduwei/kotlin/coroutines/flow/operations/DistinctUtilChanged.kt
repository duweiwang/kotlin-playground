package com.wangduwei.kotlin.coroutines.flow.operations

import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/23 8:29 PM
 *
 * 2、distinctUtilChanged
 * 2.1 如果生产的值和上个发送的值相同，值就会被过滤掉
 * 2.2 可以传参(old: T, new: T) -> Boolean，进行自定义的比较
 *
 *
 */


fun main(){
    flow {
        emit(1)
        emit(1)
        emit(2)
        emit(2)
        emit(3)
        emit(4)
    }.distinctUntilChanged()
}

// 结果：1 2 3 4
// 解释：
// 第一个1被释放
// 第二个1由于和第一个1相同，被过滤掉
// 第一个2被释放
// 第二个2由于和第一个2相同，被过滤掉
// 第一个3被释放
// 第一个4被释放


fun testDistinctUtilChangedV2() {
    class Person(val age: Int, val name: String)
    flow {
        emit(Person(20, "张三"))
        emit(Person(21, "李四"))
        emit(Person(21, "王五"))
        emit(Person(22, "赵六"))
    }.distinctUntilChangedBy { person -> person.age }

// 结果：张三 李四 赵六
}
package com.wangduwei.kotlin.basic.src.Variables

/**
 * 变量的申明有两种方式，可变和不可变。var 表示可变量。val表示不可变量
 */
fun main(args : Array<String>) {
    var message = "var means a mutable variable so you can change it. "
    println("'message' variable has this value '$message'")
    message = "wallah, modified"
    println("now 'message' has this value '$message'")

    println("")
    val forever = "val means that the variable is immutable. If you try to modify this 'forever' variable, the compiler will complain."
    println(forever)
    //immutable = "oi" -- bzz, wrong!
}

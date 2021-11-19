package com.wangduwei.kotlin.infix_fun

/**
 * 中缀函数
 */
fun main(){

    val say = "Hello " add "world"
    println(say)

    val hello = HelloWorld()
    var say3 = hello say "world 3"
    println(say3)

}

infix fun String.add(more : String) : String = this + more

class HelloWorld() {
    infix fun say(more : String) : String {
        return "Hello $more"
    }
}
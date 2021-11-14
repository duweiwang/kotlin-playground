package com.wangduwei.kotlin.basic.src.functions.OperatorOverloading

/**
 * 操作符重载
 */
fun main(Args : Array<String>) {

    var batman = SuperPower()
    batman.say()
    +batman
    batman.say()
    -batman
    batman.say()

    var robin = SuperPower()
    robin.say()
}

public class SuperPower() {
    var power : Int = 1
    var action = "Neutral"
    operator fun unaryPlus() {
        power++
        action = "+"
    }

    operator fun unaryMinus() {
        power--
        action = "-"
    }

    fun say() {
        println(action + " " + power)
    }

    override fun toString() : String = "$power"
}
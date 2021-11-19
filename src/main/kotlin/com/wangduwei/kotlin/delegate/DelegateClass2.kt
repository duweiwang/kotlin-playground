package com.wangduwei.kotlin.delegate

/**
 * 一个类实现一个接口，需要实现接口的方法。
 * 可以把实现代理给现有类
 */
fun main() {
    var me = BruceWayne(Batman(), RichyRich())
    me.inWater()
    print("Is awesomely rich? " + me.isAwesomelyRich())
}

interface Superpower {
    fun inWater()
    fun onAir()
    fun onSoil()
}

interface Wealth {
    fun isAwesomelyRich() : Boolean
}

class Batman() : Superpower {
    override fun inWater() = println("Ack, cannot swim")
    override fun onAir() = println("Requires vehicle")
    override fun onSoil() = println("Awesome")
    fun isFun(): Boolean = false
}

public class RichyRich : Wealth {
    override fun isAwesomelyRich() : Boolean = true
}

public class BruceWayne(a : Batman, b : RichyRich) : Superpower by a, Wealth by b
package com.wangduwei.kotlin.operator_overloading

fun main(){

    val counter = Counter(10)
    val counterB = Counter(10)

    println(counter + counterB)
    println(counter - counterB)
    println(counter * counterB)

    //Counter(dayIndex=20)
    //Counter(dayIndex=0)
    //Counter(dayIndex=100)

}

data class Counter(val dayIndex: Int) {

    operator fun plus(increment: Counter): Counter {
        return Counter(dayIndex + increment.dayIndex)
    }


    operator fun minus(decrement: Counter):Counter{
        return Counter(dayIndex - decrement.dayIndex)
    }

    operator fun times(times: Counter) :Counter{
        return Counter(dayIndex * times.dayIndex)
    }
}




package com.wangduwei.kotlin.basic.src.functions.LastFunctionParameter

fun main() {
    doCalculation {
        y ->
        if (y > 10)
            y + 10
        else
            y + 20
    }
}

fun doCalculation(calc : (Int) -> Int) {
    print("This is the result ${calc(10)}")
}

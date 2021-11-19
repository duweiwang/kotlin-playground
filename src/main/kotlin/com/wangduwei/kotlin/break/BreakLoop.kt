package com.wangduwei.kotlin.`break`

/**
 * 跳出循环
 */
fun main(){

    loop@ for (i in 1..50) {
        print("$i,")
        if (i == 25) {
            break@loop
        }
    }

}
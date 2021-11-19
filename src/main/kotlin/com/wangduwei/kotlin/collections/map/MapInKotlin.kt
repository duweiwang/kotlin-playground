package com.wangduwei.kotlin.collections.map


/**
 * 在Kotlin中使用Map
 */
fun main(){
    val numberMap = mapOf("key1" to 1)
    val mutableMap = mutableMapOf("one" to "one")
    val emptyMap = emptyMap<String, String>()

    val numbersMap = mutableMapOf<String, String>().apply {
        this["one"] = "1"; this["two"] = "2"
    }


    val dict = hashMapOf (
            "adam" to "Illionis",
            "bryan" to "Alabama",
            "cain" to "Oklahoma"
    )

    println("Current location ${dict["adam"]}")

    //this is called multi declaration where you assign the each pair key and value to separate variables
    for ((k, v) in dict)
        println("Key in $k has value $v")

    for (k in dict.keys)
        println("Key in '$k' with value '${dict[k]}'")

    println("Looping using entrySet")

    for (n in dict.entries)
        println("Key ${n.key} with value ${n.value}")
}
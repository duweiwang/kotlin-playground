package com.wangduwei.kotlin.collections

/**
 * Kotlin通过拓展函数和集合内置函数为集合操作提供便利
 *
 * @author : wangduwei
 * @date : 2020/4/25
 * @description :
 */

fun main() {
    CollectionOperation().test5()
}

class CollectionOperation {
    //操作不改变原来的集合
    fun test() {
        val numbers = listOf("one", "two", "three", "four")
        numbers.filter { it.length > 3 }  // nothing happens with `numbers`, result is lost
        println("numbers are still $numbers")
        val longerThan3 = numbers.filter { it.length > 3 } // result is stored in `longerThan3`
        println("numbers longer than 3 chars are $longerThan3")
    }

    //将变换存储到其他集合
    fun test2() {
        val numbers = listOf("one", "two", "three", "four")
        val filterResults = mutableListOf<String>()  //destination object
        numbers.filterTo(filterResults) { it.length > 3 }
        numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
        println(filterResults) // contains results of both operations
    }

    //修改集合
    fun test3() {
        val numbers = mutableListOf("one", "two", "three", "four")
        //排序结果放入新集合
        val sortedNumbers = numbers.sorted()
        println(numbers == sortedNumbers)  // false

        //原地排序
        numbers.sort()
        println(numbers == sortedNumbers)  // true
    }


    /**
     * 元素数量
     * 最大最小值
     * 平均值
     * 求和
     */
    fun test4() {
        val numbers = listOf(6, 42, 10, 4)

        println("Count: ${numbers.count()}")
        println("Max: ${numbers.max()}")
        println("Min: ${numbers.min()}")
        println("Average: ${numbers.average()}")
        println("Sum: ${numbers.sum()}")
    }


    /**
     * fold / reduce
     * 37
     * 42
     * 看源码：
     * reduce操作的初始值是集合的第一个元素
     * folder操作的初始值需要人为指定
     */
    fun test5() {
        val numbers = listOf(5, 2, 10, 4)
        //5+4 = 9
        //9+20 = 29
        //29+8 = 37
        val sum = numbers.reduce { sum, element ->
            sum + element * 2
        }
        println(sum)
        //0 + 10 = 10
        //10 + 4 = 14
        //14 + 20 = 34
        //34 + 8 = 42
        val sumDoubled = numbers.fold(0) { sum, element ->
            sum + element * 2
        }
        println(sumDoubled)
    }


    /**
     * filter操作->过滤
     */
    fun filterTest() {
        val list = listOf(1, 2, 3, 4)
        var result = list.filter {
            it % 2 == 0
        }
        println(result)
    }

    /**
     * map操作->
     */
    fun mapTest() {
        val list = listOf(1, 2, 3, 4)
        var result = list.map {
            it * it
        }
        println(result)

    }

}

package com.wangduwei.kotlin

import java.text.SimpleDateFormat
import java.util.*

/**
 * @desc:
 * @auther:duwei
 * @date:2019/2/15
 */
fun main()  {
    println(0L.toTimeFormat())
}

fun Long.toTimeFormat(): String {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ITALIAN)
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return format.format(calendar.time)
}
package com.wangduwei.kotlin.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * @desc: 拓展函数集中营
 * @auther:duwei
 * @date:2019/2/15
 */

/**
 * get the last char of a string
 */
fun String.lastChar(): Char = this[this.length - 1]

fun Long.toTimeFormat(): String {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ITALIAN)
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return format.format(calendar.time)
}





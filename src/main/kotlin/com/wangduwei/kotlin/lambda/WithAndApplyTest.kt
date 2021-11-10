package com.wangduwei.kotlin.lambda

import kotlin.text.StringBuilder

/**
 *  两者在lambda内部都能拿到接收者对象
 */
class WithAndApplyTest {

    /**
     * with返回执行lambda的结果，即最后一行
     */
    fun alphabet() = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\n")
        toString()
    }

    /**
     * apply返回接收者对象
     */
    fun alphabetApply() = StringBuilder().apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\n")
    }.toString()


}
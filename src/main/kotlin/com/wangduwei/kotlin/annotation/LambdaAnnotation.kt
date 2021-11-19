package com.wangduwei.kotlin.annotation


/**
 *
 * 注解可以使用在Lambda表达式
 *
 * @author : wangduwei
 * @date : 2020/8/15
 * @description :
 */

annotation class LambdaAnnotation

val f = @LambdaAnnotation { Thread.sleep(10) }
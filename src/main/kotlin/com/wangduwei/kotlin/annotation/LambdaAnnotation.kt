package com.wangduwei.kotlin.annotation


/**
 * @author : wangduwei
 * @date : 2020/8/15
 * @description :
 */
//可以使用在Lambda表达式
annotation class LambdaAnnotation

val f = @LambdaAnnotation { Thread.sleep(10) }
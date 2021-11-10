package com.wangduwei.kotlin.annotation

import kotlin.reflect.KClass

/**
 * @author : wangduwei
 * @date : 2020/8/15
 * @description :
 */
//带参数的注解
annotation class ParamAnnotation(val why: String)

//注解的参数是一个类的话，要使用KClass声明
annotation class ObjectParamAnnotation(val arg1: KClass<*>)

@ObjectParamAnnotation(String::class)
class TestObjectAnnotation
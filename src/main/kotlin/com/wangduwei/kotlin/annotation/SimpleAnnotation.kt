package com.wangduwei.kotlin.annotation

/**
 *
 * 演示在类、构造器、方法、字段上添加注解
 *
 * @author : wangduwei
 * @date : 2020/8/15
 * @description :
 */
@Target(AnnotationTarget.CLASS,
        AnnotationTarget.FIELD,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER,
        AnnotationTarget.EXPRESSION,
        AnnotationTarget.CONSTRUCTOR,
        AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.SOURCE)
annotation class SimpleAnnotation


@SimpleAnnotation//a
class Test @SimpleAnnotation constructor(i: Int) {

    var x: Int? = null
        @SimpleAnnotation set

    @SimpleAnnotation//annotation in method
    fun test(@SimpleAnnotation test: Int): Int {//annotation in parameter
        return (@SimpleAnnotation 1)
    }

}
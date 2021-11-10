package com.wangduwei.kotlin.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author 杜伟
 * @date 2020/10/10 下午8:49
 *
 */
class PropertyDelegate {


    class Person(name: String, lastName: String) {
        var name: String by FormatDelegate()
        var lastName: String by FormatDelegate()
        var updateCount = 0
    }


    class FormatDelegate : ReadWriteProperty<Any?, String> {
        private var formattedString: String = ""

        override fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return formattedString
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            formattedString = value.toLowerCase().capitalize()
        }

    }

}
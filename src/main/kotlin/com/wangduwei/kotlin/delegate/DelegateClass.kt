package com.wangduwei.kotlin.delegate

/**
 * @author 杜伟
 * @date 2020/10/10 下午8:23
 * [ArrayList] 最后删除的元素，恢复
 */
class DelegateClass {


    class ListWithTrash<T>(
            private val innerrList: MutableList<T> = ArrayList<T>()
    ) : MutableList<T> by innerrList {

        //最后被删除的
        var deleteItem: T? = null

        override fun remove(element: T): Boolean {
            deleteItem = element
            return innerrList.remove(element)
        }

        fun recover(): T? {
            return deleteItem
        }

    }


}
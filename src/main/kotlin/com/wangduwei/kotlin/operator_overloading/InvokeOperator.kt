package com.wangduwei.kotlin.operator_overloading


/**
 * 通过重载invoke操作符，屏蔽外部对内部的调用逻辑
 */
interface BitmapPool {
    companion object {
        operator fun invoke(maxSize: Int): BitmapPool {
            return if (maxSize == 0)
                EmptyBitmapPool()
            else
                RealBitmapPool()
        }
    }
}

internal class EmptyBitmapPool : BitmapPool {
}

internal class RealBitmapPool : BitmapPool {
}
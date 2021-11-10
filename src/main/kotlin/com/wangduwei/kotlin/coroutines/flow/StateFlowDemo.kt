package com.wangduwei.kotlin.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * @author 杜伟
 * @date 2021/9/24 8:22 PM
 *
 * kotlin 官方博客：
 * https://blog.jetbrains.com/kotlin/2020/10/kotlinx-coroutines-1-4-0-introducing-stateflow-and-sharedflow/
 *
 */
class StateFlowDemo {

    //内部维护的状态
    private val _state = MutableStateFlow<DownloadStatus>(DownloadStatus.NOT_REQUESTED)

    //对外暴露的不可变对象
    val state: StateFlow<DownloadStatus> get() = _state

    suspend fun download() {
        //设置为初始化状态
        _state.value = DownloadStatus.INITIALIZED
        initializeConnection()
        processAvailableContent { partialData: ByteArray,
                                  downloadedBytes: Long,
                                  totalBytes: Long ->
            storePartialData(partialData)
            _state.value = DownloadStatus.IN_PROGRESS
            println("totalBytes = $totalBytes, downloadBytes = $downloadedBytes")
        }
        //设置为成功
        _state.value = DownloadStatus.SUCCESS
    }

    /**
     * 模拟下载进度
     */
    private suspend fun processAvailableContent(function: suspend (ByteArray, Long, Long) -> Unit) {
        var i = 0L
        while (i < 5) {
            delay(200)
            function.invoke(ByteArray(10), i, 5)
            i++
        }

    }

    sealed class DownloadStatus {
        object SUCCESS : DownloadStatus()
        object NOT_REQUESTED : DownloadStatus()
        object INITIALIZED : DownloadStatus()
        object IN_PROGRESS : DownloadStatus()
    }


    private fun initializeConnection() {}

    /**
     * 模拟数据存储
     */
    private suspend fun storePartialData(partialData: ByteArray) {
        println("......storing data")
        delay(500)
    }


}
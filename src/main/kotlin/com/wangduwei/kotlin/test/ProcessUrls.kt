package com.wangduwei.kotlin.test

import java.io.File
import java.io.IOException

/**
 * @author 杜伟
 * @date 5/13/21 9:18 AM
 *
 * nemo极客资源网站链接处理没去掉没用的字符
 *
 */


fun main() {
    val fileName = "/Users/wangduwei/Documents/files/untitled.html"
    val file = File(fileName)

    val results = mutableListOf<String>()

    if (file.exists()) {
        println("find target file")

        val lines = file.readLines()
        lines.forEach {
            var result = it
            if (result.contains("</a>")) {
                val index = it.lastIndexOf("</a>")
                result = it.replaceRange(startIndex = index + 4, endIndex = it.length, "")
            }
            if (result.contains("href=\"")){
//                val index = it.lastIndexOf("href=\"")
                result = it.replace("href=\"47.74.184.161:10000/","href=\"www://47.74.184.161:10000/")
            }
            results.add(result)
        }

        if (results.isNotEmpty()) {
            write2File(results, file)
        }
    }
}

private fun write2File(list: List<String>, file: File) {
    val writer = file.bufferedWriter()
    try {
        list.forEach {
            writer.write(it)
            writer.newLine()
        }
    }catch (e:IOException){
        e.printStackTrace()
    }finally {
        writer.close()
    }
}
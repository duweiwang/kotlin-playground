package com.wangduwei.kotlin.coroutines.channel.consumer

import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author 杜伟
 * @date 2021/9/19 2:36 PM
 *
 * One Consumer Consuming From Several Producers
 *
 */

suspend fun fetchYoutubeVideos(channel: SendChannel<String>) {
    val videos = listOf("cat video", "food video")
    for (video in videos) {
        delay(100)
        channel.send(video)
    }
}

suspend fun fetchTweets(channel: SendChannel<String>) {
    val tweets = listOf("tweet: Earth is round", "tweet: Coroutines and channels are cool")
    for (tweet in tweets) {
        delay(100)
        channel.send(tweet)
    }
}

fun main() = runBlocking {
    val aggregate = Channel<String>()
    launch { fetchYoutubeVideos(aggregate) }
    launch { fetchTweets(aggregate) }

    repeat(4) {
        println(aggregate.receive())
    }

    coroutineContext.cancelChildren()
}
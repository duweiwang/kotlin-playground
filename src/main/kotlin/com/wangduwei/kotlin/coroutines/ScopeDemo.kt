import kotlinx.coroutines.*


/**
 * 这个例子演示了：doWork抛出异常。外部的try-catch无效。仍然崩溃
 *
 */
val job: Job = Job()
val scope = CoroutineScope(Dispatchers.Default + job)

fun doWork(): Deferred<String> = scope.async {
    throw RuntimeException()
    ""
}   // (1)
fun loadData() = scope.launch {
    try {
        doWork().await()                               // (2)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun main() = runBlocking {

    loadData()


    delay(5_000)
}
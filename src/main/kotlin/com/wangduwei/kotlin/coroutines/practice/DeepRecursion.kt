package com.wangduwei.kotlin.coroutines.practice

/**
 * @author 杜伟
 * @date 2021/10/30 10:14 AM
 *
 * 协程解决深度递归问题
 *
 * https://elizarov.medium.com/deep-recursion-with-coroutines-7c53e15993e3
 *
 */
class Tree(val left: Tree?, val right: Tree?)

object BetterSolution{

    @ExperimentalStdlibApi
    val depth = DeepRecursiveFunction<Tree?, Int>(block = { t ->
        if (t == null) 0 else maxOf(
            callRecursive(t.left),
            callRecursive(t.right)
        ) + 1
    })
}

@ExperimentalStdlibApi
fun main(){
    val n = 3//100_000
    val deepTree = generateSequence(Tree(null, null)) { prev ->
        Tree(prev, null)
    }.take(n).last()

//    println(WrongSolution.depth(deepTree))//Exception in thread "main" java.lang.StackOverflowError
//    println(SolutionProve.depth(deepTree))
    println(BetterSolution.depth(deepTree))
}
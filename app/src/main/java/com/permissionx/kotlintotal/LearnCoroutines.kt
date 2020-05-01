package com.permissionx.kotlintotal

import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * 协程使用
 *
 * 协程作用域创建：
 *

 *

 *

 *

 *

 *
 * */

/**
 *  * 1. GlobalScope.launch {  }
 *    创建的是顶层协程，这种协程当应用程序运行结束时也会跟着一起结束
 */
fun testGlobalScope(){
    GlobalScope.launch {
        //创建顶层协程
    }
}

/**
 * 2.runBlocking{  }
 *    创建的协程可以保证写成作用域内的所有代码和子协程没有全部执行完之前会一直阻塞当前线程
 */
fun testRunBlocking(){
    runBlocking {
        //
    }
}



/**
 * 3. 函数launch{}
 *    只有在协程作用域内才能被调用，在当前协程作用域下创建子协程。
 *    子协程的特点：外层作用域协程结束，该作用域下所有子协程也会一同结束
 */
fun testLaunch(){
    runBlocking {
        launch {

        }
    }
}

/**
 * 4. 挂起函数
 *    形式：suspend fun methodName(){}
 *    用于封装launch函数中部分逻辑代码
 *    特点：挂起函数间可以相互调用，协程作用域也可以调用，但无法提供协程作用域
 */
suspend fun testSuspendFunc(){
    println(".")
    delay(1000)
}

/**
 * 5. coroutineScope 函数
 *    是一个挂起函数，但是会继承外部协程作用域并创建一个子作用域
 *    特点：保证其作用域内所有代码和子协程在全部执行完之前，会一直阻塞当前线程
 *    示例：
 *    suspend fun printDot() = coroutineScope{
 *          launch{
 *              println(".")
 *              delay(1000)
 *          }
 *    }
 */
fun testCoroutineScope(){
    runBlocking {
        coroutineScope {
            launch {
                for (i in 1..10){
                    println(".")
                    delay(1000)
                }
            }
        }
        println("coroutineScope done")
    }
    println("runBlocking done")
}

/**
 * 取消协程
 * launch{}函数会返回一个job对象，调用job.cancel()取消协程
 *
 * 但是一般不用这种方法，常用示例如下
 */
fun cancelCoroutine(){
    val job = Job()
    val scope = CoroutineScope(job)
    scope.launch {
        //执行具体逻辑
    }
    scope.launch {
        //执行具体逻辑
    }
    scope.launch {
        //执行具体逻辑
    }
    //每次调用CoroutineScope的launch函数所创建的协程都会被关联在job对象的作用域下面，只需调用一次cancel方法，就可以将该作用域下所有的协程全部取消
    job.cancel()
}

/**
 * launch{ }函数的返回值永远都是一个job对象，因此只能用来只能执行一段逻辑
 *
 * async{ }函数
 * 用法：必须在协程作用域中调用，会创建一个新的子协程并返回一个Deferred对象，调用deferred对象的await方法可以获得执行结果
 *
 * 特点：
 *     调用async{}函数后，代码块中代码会立即执行，当调用到await方法时，如果代码块中的代码还没执行完，await()函数就会将当前协程阻塞住，直到可以获得函数执行结果
 *
 *     因此，写完async函数后一般不立即调用await函数获取结果，而是在需要用到async函数执行结果的时候再调用await方法获取结果
 *
 *    async函数有一种简化写法withContext(Dispatchers.Default)  这是一个挂起函数，接收一个线程参数
 *
 *       Dispatchers.Default：适用于执行代码属于计算密集任务时
 *       Dispatchers.IO：适用于执行代码大多数时间是在阻塞和等待中， 比如网络请求
 *       Dispatchers.Main：表示不会开启子线程，而是在Android主线程中执行代码
 */

fun testAsync(){

    runBlocking {
        val result = async {
            5+5
        }.await()
        println(result)

        val result1 = withContext(Dispatchers.Default){
            5+5//最后一行代码是返回值
        }
    }
}

/**
 * suspendCoroutine函数
 *
 * 作用：用于简化任何回调的写法
 *
 * 必须在协程作用域或者挂起函数中才能调用，接收一个lambda表达式参数，
 * lambda表达式参数列表上会传入一个continuation参数，调用它的resume()函数或者resumeWithException()可以让线程恢复执行
 */

suspend fun testSuspendCoroutine(){
//    HttpUtil.sendHttpRequest("https://www.baidu.com",object :HttpCallbackListener{
//        override fun onFinish(response: String) {
//
//        }
//
//        override fun onError(e: Exception) {
//
//        }
//    })

    //简化处理
    try {
        val response = request("https://www.baidu.com")
    }catch (e:Exception){

    }
}



suspend fun request(address:String):String{
    return suspendCoroutine { continuation ->
        HttpUtil.sendHttpRequest(address,object :HttpCallbackListener{
            override fun onFinish(response: String) {
                continuation.resume(response)
            }

            override fun onError(e: Exception) {
                continuation.resumeWithException(e)
            }
        })
    }
}

object HttpUtil{

    fun sendHttpRequest(address:String, callback:HttpCallbackListener){}
}

interface HttpCallbackListener{
    fun onFinish(response:String)
    fun onError(e:Exception)
}

fun main(){



}
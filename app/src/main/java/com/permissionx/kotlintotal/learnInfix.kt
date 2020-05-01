package com.permissionx.kotlintotal

/**
 * infix函数
 *
 * 构建可读性更强的语法
 *
 * 类似创建map的 A to B
 *
 * 其中to()函数的源码：
 *
 * public infix fun<A,B> A.to(that:B) : Pair<A,B> = Pair(this,that)
 *
 * 函数声明：最前面加上infix关键字
 * */

infix fun String.beginWith(prefix:String) = startsWith(prefix)

fun main(){

    val map = mapOf("apple" to 2,"pear" to 4)

    //可以实现类似map的 A to B 这种语法
    val result = "Hahaha" beginWith "hehehe"
}
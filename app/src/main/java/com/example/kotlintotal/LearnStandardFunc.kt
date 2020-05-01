package com.example.kotlintotal

import java.lang.StringBuilder

/**
 * 常用kotlin标准函数学习
 * */


/**
 * let函数
 *
 * 语法规则：
 * obj.let{ obj2 ->
 *      //具体逻辑
 * }
 *
 * 此处obj和obj2是同一个对象，只是为了区分
 *
 * 注意：相比较if(study!=null) let函数可以进行全局变量的非空判断
 *
 */
fun funcLet(study: Study?){
    study?.let {
        it.readBooks()
        it.doHomeWork()
    }
}

/**
 * with函数
 *
 * 语法规则：
 * val result = with(obj){
 *      //这里是obj的上下文
 *      "value"//with函数的返回值
 * }
 */
fun funcWith(){
    val list = listOf<String>("apple","banana","pear","orange")
    val result = with(StringBuilder()){
        for (fruit in list){
            append(fruit).append("\n")
        }
        toString()//返回值
    }
    println(result)
}

/**
 * run函数
 *
 * 语法规则：
 * val result = obj.run{
 *      //这里是obj的上下文
 *      "value"//with函数的返回值
 * }
 */
fun funcRun(){
    val list = listOf<String>("apple","banana","pear","orange")
    val result = StringBuilder().run{
        for (fruit in list){
            append(fruit).append("\n")
        }
        toString()//返回值
    }
    println(result)
}

/**
 * run函数
 *
 * 语法规则：
 * val result = obj.apply{
 *      //这里是obj的上下文
 *
 * }
 * result == obj //无法指定返回值，返回调用对象本身
 */
fun funcApply(){
    val list = listOf<String>("apple","banana","pear","orange")
    val result = StringBuilder().apply{
        for (fruit in list){
            append(fruit).append("\n")
        }

    }
    println(result.toString())
}
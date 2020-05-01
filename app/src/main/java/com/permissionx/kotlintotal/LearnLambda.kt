package com.permissionx.kotlintotal

import android.content.Context
import android.view.View
import android.widget.TextView
import java.util.*

/**
 * lambda基础
 *
 * */

/**
 * lambda语法结构
 *
 * {参数名1：参数类型，参数名2：参数类型  ->  函数体}
 *
 * */

/**
 * 集合
 */
fun collectionAndMapWithFor(){
    //list
    val list = listOf<String>("apple","banana","orange","pear","grape")//只读list
    val mutableList = mutableListOf<String>("apple","banana","orange","pear","grape")//可变list
    mutableList.add("mango")
    for (fruit in list) println(fruit)

    //set
    val set = setOf<String>("apple","banana","orange","pear","grape")//只读set
    val mutableSet = mutableSetOf<String>("apple","banana","orange","pear","grape")//可变set
    mutableSet.add("mango")
    for (fruit in set) println(fruit)

    //map
    val map = mapOf<String,Int>("apple" to 1,"banana" to 2,"orange" to 3,"pear" to 4,"grape" to 5)//只读map
    val mutableMap = mutableMapOf<String,Int>("apple" to 1,"banana" to 2,"orange" to 3,"pear" to 4,"grape" to 5)//可变map
    mutableMap["mango"] = 6//代替put方法
    for ((fruit,number) in map) println("current fruit is $fruit, current number is $number")


}

/**
 * 集合的函数式API
 *
 * 其语法结构是lambda表达式
 */
fun maxByTest(){
    val list = listOf<String>("apple","banana","orange","pear","grape")
    var maxLengthFruit:String = list.maxBy {it.length} as String
    println(maxLengthFruit)

}

/**
 * maxBy函数分析
 *
 * list.maxBy 接收一个lambda参数
 */
fun maxByAnalyze(){
    val list = listOf<String>("apple","banana","orange","pear","grape")
//    val lambda = {fruit:String -> fruit.length}
//    list.maxBy(lambda)
    //直接传入一个lambda表达式
    list.maxBy({fruit:String -> fruit.length})
    //kotlin规定如果lambda参数是函数的最后一个参数，可以将其放到函数括号的外面
    list.maxBy() { fruit:String -> fruit.length }
    //kotlin规定如果lambda参数是函数的唯一一个参数，括号可以省略
    list.maxBy{ fruit:String -> fruit.length }
    //lambda表达式大多数情况下参数类型可以省略
    list.maxBy{ fruit -> fruit.length }
    //只有一个参数时，参数名也可以省略,使用it关键字来代替
    list.maxBy { it.length }

}

//集合的其他函数API使用
fun otherFuncAPITest(){
    val list = listOf<String>("apple","banana","orange","pear","grape","watermelon")

    val newList = list
        .filter { it.length<5 }//按照某种条件过滤
        .map { it.toUpperCase(Locale.getDefault()) }//按照某种关系进行映射
    for (fruit in newList){
        println(fruit)
    }

    val result1:Boolean = list.any { it.length<=5 }//至少有一个
    val result2:Boolean = list.all { it.length<=5 }//是否全部都满足
}

/**
 * java中的函数式api调用
 *
 * 注意：只有Java语言定义的单抽象方法接口，在kotlin可以使用函数式api的写法
 */
fun funcAPIInJava(context:Context){
    Thread{
        //执行逻辑
    }.start()

    val view = TextView(context)
    view.setOnClickListener{

    }
}

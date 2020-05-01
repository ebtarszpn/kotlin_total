package com.permissionx.kotlintotal

/**
 * kotlin基础语法知识
 */


/**
 * 变量的声明
 * 使用关键字：var和val
 */
fun variableNamed() {
    //1.var 可变变量
    var a = 10
    a = 11
    //2.val 只读变量
    val b = 10
}

/**
 * 函数的声明
 * 格式：
 * fun methodName(param1:ParamType, param2:ParamType):ReturnValueType{
 *
 * }
 * 示例如下：
 * 函数名为：methodGetLargeNumber
 * 参数一:a  类型：Int
 * 参数二:b  类型：Int
 * 返回值:a+b 类型：Int
 */
fun methodGetLargeNumber(a: Int, b: Int): Int {
    return a + b
}

/**
 * 函数的参数可以设置默认值
 *
 */
fun methodGetLargeNumberWithDefaultParamValue(a: Int, b: Int = 5): Int {
    return a + b
}

fun methodInvokeTest(a: Int = 5, b: String) {

}

fun main(){
    //参数带有默认值的函数调用
    methodGetLargeNumberWithDefaultParamValue(7)
    //键值对传参调用 ,这种方式可以不用考虑参数顺序
    methodInvokeTest(b="Tom",a=5)
}

/**
 * 当函数中只有一行代码时，kotlin规定我们不必编写函数体
 *
 * 示例如下：
 */
fun methodGetLargeNumber2(a: Int, b: Int): Int = a + b

/**
 * 基于kotlin出色的类型推到机制,返回值类型可以省略
 *
 * 示例如下：
 */
fun methodGetLargeNumber3(a: Int, b: Int) = a + b

/**
 * 条件语句if
 *
 * 利用if语句来获得两个数的最大值
 */
fun methodGetLargeNumberWithIf(num1: Int, num2: Int): Int {
    var value = 0
    if (num1 > num2) {
        value = num1
    } else {
        value = num2
    }
    return value
}

/**
 * 由于kotlin的if语句是可以有返回值的，因此函数可以简化为如下：
 *
 */

//简化1：
fun methodGetLargeNumberWithIf1(num1: Int, num2: Int): Int {

    return if (num1 > num2) {
        num1
    } else {
        num2
    }
}

//简化2：
fun methodGetLargeNumberWithIf2(num1: Int, num2: Int)=if (num1 > num2) {
    num1
} else {
    num2
}

//简化3：
fun methodGetLargeNumberWithIf3(num1: Int, num2: Int)= if (num1 > num2) num1 else num2

/**
 * 条件语句when:
 *
 * 语法：匹配值 -> {执行逻辑}
 * 和if语句一样 也可以有返回值
 */

//根据名字获取分数（精确匹配）
fun getScoreWithWhen(name:String) = when(name){
    "Tom" -> 86
    "Jack" -> 90
    "Lily" -> 80
    else -> 0
}

//根据名字获取分数（不带参数使用） 拓展性更强
fun getScoreWithWhenNoName(name:String) = when{
    name.startsWith("Tom") -> 86
    name == "Jack" -> 90
    name =="Lily" -> 80
    else -> 0
}

//检查数字类型（类型匹配）
fun checkNumberWithWhen(num:Number) = when(num){
    is Int -> println("number is Int")
    is Float -> println("number is Float")
    is Double -> println("number is Double")

    else -> println("number is UnKnow")
}

/**
 * 循环语句
 *
 * 分为两种：while、for
 * while循环用法不变
 * Java中的for-i 循环被舍弃了， 另一种强大的for-each循环 被 for-in循环取代
 */


/**
 * 这里用到了字符串内嵌表达式${} 当表达式中仅有一个变量时，可以省略大括号
 * 语法规则："Hello ,${obj.name}, nice to meet you!"
 * 省略大括号后："Hello ,$name, nice to meet you!"
 */
fun loopWithWhile(){
    var num = 10
    while (num>=0){
        println("current num is $num")
        num--
    }
    println("While done")
}


fun loopWithFor(){
    val num1 = 1..10//创建一个区间[1.10]
    val num2 = 1 until 10//创建一个区间[1.10)
    val num3 = 10 downTo  1//创建一个降序区间[10.1]

    for (i in num1) {println(i)}
    for (i in num2 step 2) {println(i)}//默认i++, 使用step 这里相当于i+2
    for (i in num3) {println(i)}
}



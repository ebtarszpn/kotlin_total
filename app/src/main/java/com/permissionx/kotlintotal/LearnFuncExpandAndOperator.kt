package com.permissionx.kotlintotal

/**
 * 拓展函数和运算符重载
 * */


/**
 * 拓展函数语法规则:
 *
 * fun ClassName.methodName(param1:Int, param2:Int):Int{
 *      return 0
 * }
 *
 * 为了方便查找 当你为哪个类添加拓展函数时，就新建一个对应的ClassName.kt文件。比如：String.kt
 *
 * */

/**
 * 定义一个计算字符串中字母数量的拓展函数
 */
fun String.lettersCount():Int{
    var count=0
    for (char in this){
        if (char.isLetter())count++
    }
    return count
}

/**
 * 运算符重载
 *
 * 使用场景：
 * 定义一个Money类，成员有value和type, 当我们希望通过以totalMoney = money+money的形式来获得总钱数，类型保持为money
 * 这时候就需要用到运算符重载
 *
 * 语法结构：
 *
 * class obg{
 *
 *      //以运算符plus为例
 *      operator fun plus(obj:Obj):
 * }
 * */

class Money( val value:Int){

    operator fun plus(money: Money):Money{
        return Money(money.value + value)
    }
}

/**
 * 结合拓展函数和运算符重载，可以按照需求增强原有运算符的功能
 *
 * 示例：通过乘法实现将字符串重复多次的效果
 *
 * repeat()函数是String提供的将字符串重复n遍的函数
 * */

operator fun String.times(n:Int) = repeat(n)



fun main(){

    println("anchdakd123**&^%".lettersCount())

    val money1 = Money(5)
    val money2 = Money(10)
    val money = money1+money2
    println(money.value)

    val str = "haheha"
    println(str * (1..20).random())
}
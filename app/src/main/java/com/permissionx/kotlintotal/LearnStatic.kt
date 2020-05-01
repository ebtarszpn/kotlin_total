package com.permissionx.kotlintotal

/**
 * 静态方法
 *
 * 分为语法形式上的静态和真正意义上的静态
 */

//单例（语法形式静态）
object Util{
    fun doAction(){
        println("do action")
    }
}

/**
 * companion object
 *
 * companion object{}会在当前类中创建一个伴生类，而且kotlin保证当前类始终只会存在一个伴生对象
 *
 * Util2.doAction2()实际上是调用的伴生对象的方法
 *
 */
class Util2{

    fun doAction(){
        println("do action")
    }

    companion object{
        fun doAction2(){
            println("do action2")
        }
    }
}

/**
 * 真正的静态
 *
 * 使用注解@JvmStatic
 * @JvmStatic 只能在单例类或者companion object中使用
 *
 * 示例：Util3、Util4
 *
 */
class Util3{

    fun doAction(){
        println("do action")
    }

    companion object{
        @JvmStatic
        fun doAction2(){
            println("do action2")
        }
    }
}

object Util4{

    @JvmStatic
    fun doAction(){
        println("do action")
    }
}

fun main(){
    Util2.doAction2()
}
package com.permissionx.kotlintotal

import android.content.Context
import android.content.Intent
import kotlin.reflect.KProperty

/**
 * 泛型和委托
 * */


/**
 * 泛型主要有两种定义方式
 * 泛型类和泛型方法
 *
 * */

class MyTest<T> {

    fun func(t: T) {}
}

class MyTest1 {
    fun <T> func(t: T) {}
}

//对泛型进行限制，示例：
class MyTest2 {

    fun <T : Number> func(t: T) {}//泛型限制为数字类型
}

//使用泛型将open函数拓展至所有类

fun <T> T.open(block: T.() -> Unit): T {
    block()
    return this
}

/**
 * 泛型的高级用法
 *
 * 内联函数泛型实例化
 *
 * 关键字 inline、 reified
 */

inline fun<reified T> getGenericType(){}

//应用：Activity跳转
inline fun<reified T> startActivity(context: Context,block: Intent.() ->Unit){
    val intent = Intent(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}



/**
 * 委托是一种设计模式
 *
 * 基本理念：操作对象自己不会去处理某段逻辑，而是会把工作委托给另一个辅助对象去处理
 *
 * 语法结构：
 *
 * class MyClass{
 *      val p by Delegate()
 * }
 *
 * class Delegate{
 *
 *      val propValue: Any? = null
 *
 *      //第一个参数声明该delegate类的作用范围， myClass表示仅在MyClass类中使用
 *      //第二个参数是kotlin的一个属性操作类，暂时不用
 *      operator fun getValue(myClass:MyClass,prop:KProperty<*>):Any?{
 *          return propValue
 *      }
 *
 *      operator fun setValue(myClass:MyClass,prop:KProperty<*>, value: Any?){
 *          propValue = value
 *      }
 *
 * }
 *
 * 委托工作流程：当我们给变量p赋值时，实际上是调用了Delegate类的setValue()方法, 获取值时，调用了getValue()方法
 *              如果变量p是val修饰的，只用实现getValue方法就可以了
 * */


/**
 * 按照委托模式 实现自己的lazy函数
 *
 * 1.创建委托类Later 指定泛型T, 扩大委托类作用范围
 *
 * 2.声明高阶函数later,返回一个委托类对象
 */

class Later<T>(private val block: () -> T){

    var value:Any? = null

    operator fun getValue(any:Any?, propValue:KProperty<*>):T?{
        value = block()
        return value as T
    }
}

fun<T> later(block:()->T) = Later(block)

fun main(){

    val p by later {
        "hahaha"
    }
}


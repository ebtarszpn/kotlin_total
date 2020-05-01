package com.example.kotlintotal

import android.content.SharedPreferences
import java.lang.StringBuilder

/**
 * 高阶函数
 *
 *
 * kotlin中允许一个函数的参数类型是另一个函数
 *
 * 当一个函数的参数声明或者返回值声明是一个函数类型，那么该函数就是一个高阶函数
 *
 * 函数类型语法结构： (String,Int) -> Unit  其中Unit相当于Java中的Void,表示没有返回值  如果有返回值，则要写对应的返回值类型
 *
 *
 * */

fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

/**
 * 仿照apply函数
 * 实现StringBuilder的build函数
 *
 * 知识点：拓展函数，高阶函数
 */

fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

/**
 * 高阶函数在Java中是以匿名内部类实现的，因此会造成额外的内存和性能开销，为了解决这个问题，kotlin提供了内联函数
 *
 * 即在定义高阶函数时加上 inline 关键字
 */
inline fun example(block: () -> Unit) {

}

/**
 * 参数为多个lambda表达式时，不想被内联的lambda表达式可以使用noinline来标识
 *
 * 示例如下：只内联block1
 *
 * 内联的函数类型参数在编译的时候会被进行代码替换，没有真正的参数属性，内联的函数类型参数只允许传递给另一个内联函数
 * 非内联的函数类型参数可以自由的传递给其他任何函数，是一个真正的参数
 *
 * 内联函数可以使用return关键字来进行函数返回
 *
 * 非内联函数只能进行局部返回
 */
inline fun example2(block1: () -> Unit, noinline block2: () -> Unit) {

}

/**
 * 内联函数的lambda表达式允许使用return关键字进行返回 而如果高阶函数的匿名类中不允许使用return关键字，此时为了解决冲突，
 * 引入了crossinline 用来约束lambda表达式一定不使用return来进行返回 但是可以使用return@XXX来进行局部返回
 *
 * 示例如下：
 */

inline fun rnRunnable(crossinline block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
    runnable.run()
}

/**
 * 使用高阶函数简化share Preference
 *
 * String.() -> Unit
 *
 * 函数类型前加类名. 表示限定该函数类型的作用域， 并且自动拥有类名所在类的上下文
 * */

fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit, isCommit: Boolean = false) {
    val editor = this.edit()
    editor.block()
    if (!isCommit) editor.apply() else editor.commit()
}

fun SharedPreferences.open1(block: () -> Unit, isCommit: Boolean = false) {
    val editor = this.edit()
    editor.apply {
        block()
    }
    if (!isCommit) editor.apply() else editor.commit()
}




fun main() {
    //调用支持lambda表达式
    num1AndNum2(1, 2) { n1, n2 ->
        n1 + n2
    }

    val list = listOf<String>("apple", "banana", "pear")
    val stringBuilder = StringBuilder().build {
        list.forEach {
            append(it)
        }
    }
    println(stringBuilder.toString())


}



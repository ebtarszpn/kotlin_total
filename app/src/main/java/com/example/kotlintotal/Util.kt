package com.example.kotlintotal

import android.content.Context
import android.view.View
import android.widget.Toast
import java.lang.RuntimeException
import com.google.android.material.snackbar.Snackbar


/**
 * 编写好用的工具类
 * */

/**
 * 获取n个元素的最大值
 *
 * 要点：泛型 可比较
 */

fun <T : Comparable<T>> getMaxElement(vararg elements: T): T {
    if (elements.isEmpty()) throw RuntimeException("Params can not be empty")
    var maxElement = elements[0]
    for (element in elements) {
        if (element > maxElement) {
            maxElement = element
        }
    }
    return maxElement
}

/**
 * 简化Toast用法
 */

fun String.toast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this, duration).show()
}

/**
 * 简化snakeBar用法
 *
 * Snackbar.make(view,text,duration).setAction(textAction,listener).show()
 *
 */

fun View.showSnakeBar(
    text: String,
    textAction: String? = null,
    duration: Int = Snackbar.LENGTH_SHORT,
    action: (() -> Unit)? = null
) {
    val snackBar = Snackbar.make(this, text, duration)
    if (textAction != null && action != null) {
        snackBar.setAction(textAction){action()}
    }
    snackBar.show()

}

fun main() {
    println(getMaxElement("aaa", "bbb", "eee", "www"))
}
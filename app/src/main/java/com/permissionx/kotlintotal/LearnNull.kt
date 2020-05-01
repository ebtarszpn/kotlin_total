package com.permissionx.kotlintotal

/**
 * 空类型学习
 *
 * */

fun main(){
    doStudy(null)
}

/**
 * 判空操作符 ?.
 *
 * 参数类型声明为可空类型时，参数才可以传null
 *
 * 声明写法：参数类型后加?
 * 参数调用：参数名?.XXX
 */
fun doStudy(study: Study?){
    study?.readBooks()
    study?.doHomeWork()
}

//获取一段文字的长度
fun getTextLength(text:String?):Int{
    if(text!=null){
        return text.length
    }
    return 0
}

/**
 * 使用?:对上述方法进行优化
 */
fun getTextLength1(text: String?) = text?.length?:0

/**
 * 如果确定某个变量逻辑上肯定不为空
 * 可以使用断言  !!. 来跳过kotlin的空指针检查
 *
 * 示例：
 * val content
 *
 * content!!.toUpperCase()
 *
 * */
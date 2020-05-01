package com.example.kotlintotal

/**
 * 延迟初始化和密封类
 * */

/**
 * late init
 */
class Late{
    //通常情况下如果我们不为声明的变量进行赋值，就要声明为可空类型，用到的时候要做相应的非空判断
    var name1:String? = null

    //为了避免这种情况可以使用延迟初始化
    lateinit var name2:String
}

/**
 * 密封类
 *
 * 类名前加sealed关键字
 *
 * 当条件语句when(param){}的条件参数类型为密封类时，kotlin会自动检查该密封类有哪些子类，并且强制要求将每一个子类的条件都进行处理
 * 这样就可以省略else判断
 */

sealed class SealedHolder{

}
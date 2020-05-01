package com.permissionx.kotlintotal

/**
 * 类
 * kotlin也是面向对象编程的
 * */

/**
 *
 *
 * kotlin的构造函数分为两种：主构造函数和次构造函数
 *
 * 主构造函数：写法是在类名后加一对括号 括号内可以按需添加参数
 * 主构造函数特点：没有函数体 执行逻辑写在init{}结构体里
 *
 * #### 一般情况下，每个类都默认有一个无参的主构造函数 ####
 *
 * 次构造函数：数量不限 可以有多个
 * 通过关键字constructor声明、
 * 次构造函数实际很少使用是因为，我们可以通过给主构造函数设置默认值，然后用任何传参组合的方式来进行实例化
 */
class Robert
class Robert2(val name: String, val age:Int)
class Robert3(val name: String, val age:Int){
    init {
        //添加主构造函数逻辑
    }

    constructor():this("Tom",5)
    constructor(name: String, age:Int,gender: String):this(name,age)
    constructor(name: String, age:Int,gender: String,country:String):this(name,age)
}

class Robert4{
    //当一个类没有显式定义主构造函数，而且定义了次构造函数。这个类就是没有主构造函数的
    constructor(name:String, age: Int)
}

/**
 * 一个类没有主构造函数，且存在继承关系时：
 * 1.父类后面不用加（）
 * 2.次构造函数通过super调用父类的主构造函数
 */
class Robert5:Person{
    constructor(name:String, age: Int):super(name,age)
}


/**
 * open 修饰类 表示可被继承
 */
open class Person(var name:String, var age:Int)

//
/**
 * 子类继承父类需要调用父类的构造函数
 *
 * 在主构造函数中参数前用var或者val修饰，该参数将自动成为该类的成员
 * 参数name和age不加var和val,表示这两个变量的作用域仅限在主构造函数中
 */
class Student( name:String, age:Int):Person(name,age)

class Teacher( name:String, age:Int):Person(name,age)

/**
 * 接口定义
 */
interface Study{
    fun doHomeWork(){
        //默认实现
        println("doHomework is default action")
    }
    fun readBooks()

}

/**
 * kotlin中继承和实现都用冒号来代替，中间用逗号分隔
 *
 * kotlin接口中允许对函数进行默认实现
 */
class Student1(name:String,age:Int):Person(name,age),Study{

    override fun doHomeWork() {

    }

    override fun readBooks() {

    }
}

/**
 *
 */

/**
 * 数据类
 *
 * 写法：data class 类名(参数：参数类型，......){}
 *
 * 主构造函数至少有一个参数
 *
 * kotlin会根据主构造函数中的参数重写equals()、hashCode()、toString()方法
 */
data class Phone(val brand:String)

/**
 * 单例类
 *
 * 声明使用关键字 object
 */
object Singleton{
    fun singletonTest(){
        println("this is a singleton's func")
    }
}
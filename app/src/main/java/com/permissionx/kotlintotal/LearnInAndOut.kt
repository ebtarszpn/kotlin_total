package com.permissionx.kotlintotal

import java.lang.StringBuilder
import javax.sql.StatementEvent

/**
 * 泛型的协变（out）和逆变(in)
 *
 * 协变：out T  只能出现在返回值位  向上转型
 *
 * 逆变：in T  只能出现在参数位  向下转型
 *
 * */

class SimpleData<out T>(private val data:T?) {

    fun get(): T? {
        return data
    }
}

fun handleSimpleData(data:SimpleData<Person>){
    when(data.get()){
        is Person -> println("type is person")
        is Teacher -> println("type is teacher")
        is Student -> println("type is student")
        else -> println("type is unKnow")
    }

}

interface Transformer<in T>{
    fun transform(t:T):String
}

fun handleTransformer(student: Student,trans: Transformer<Student>){
    println(trans.transform(student))
}

fun main(){
    val student = Student("Tom",18)
    val data = SimpleData<Student>(student)
    handleSimpleData(data)

    val trans = object : Transformer<Person>{
        override fun transform(t: Person):String {
            return "${t.name} ${t.age}"
        }
    }
    handleTransformer(Student("Tom",19),trans)
}
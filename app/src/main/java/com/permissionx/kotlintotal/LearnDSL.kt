package com.permissionx.kotlintotal

import com.google.android.material.tabs.TabLayout
import java.lang.StringBuilder

/**
 *
 * 使用DSL创建专有语法结构
 * */


/**
 *
 *示例：动态生成表格对应的html 代码
 */
class Td{
    var content = ""
    fun html() = "\n\t\t<td>$content</td>"
}

class Tr{
    private val children = ArrayList<Td>()

    fun td(block:Td.()->String){
        val td = Td()
        td.block()
        children.add(td)
    }

    fun html(){
        val builder = StringBuilder()
        builder.append("\n\t<tr>")
        for (childTag in children){
            builder.append(childTag.html())
        }
        builder.append("\n\t</tr>")
    }
}

class Table{
    private val children = ArrayList<Tr>()

    fun tr(block:Tr.()->Unit){
        val tr = Tr()
        tr.block()
        children.add(tr)
    }

    fun html(){
        val builder = StringBuilder()
        builder.append("<table>")
        for (childTag in children){
            builder.append(childTag.html())
        }
        builder.append("</table>")
    }
}

fun table(block:Table.()->Unit):String{
    val table = Table()
    table.block()
    return table.toString()
}


fun main(){

    table {
        tr {
            td { "hahaha" }
            td { "hahaha" }
            td { "hahaha" }
        }
        tr {
            td { "hahaha" }
            td { "hahaha" }
            td { "hahaha" }
        }
        
    }

}
package main

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
    var random: Node? = null

    override fun toString(): String {
        var temp: Node? = this
        var result = ""
        while (temp != null) {
            result += temp.`val`
            temp = temp.next
        }
        return result
    }
}
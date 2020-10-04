package medium

import main.Node
import main.Solution

/**
 * Example:
 * var ti = main.Node(5)
 * var v = ti.`val`
 * Definition for a main.Node.
 * class main.Node(var `val`: Int) {
 *     var next: main.Node? = null
 *     var random: main.Node? = null
 * }
 */

class Solution138 : Solution() {
    override fun test() {
        val input = Node(7)
        input.next = Node(13)
        input.next!!.next = Node(11)
        input.next!!.next!!.next = Node(10)
        input.next!!.next!!.next!!.next = Node(1)
        input.next!!.random = input
        input.next!!.next!!.random = input.next!!.next!!.next!!.next
        input.next!!.next!!.next!!.random = input.next!!.next
        input.next!!.next!!.next!!.next!!.random = input
        println(copyRandomList(input))
    }

    fun copyRandomList(node: Node?): Node? {
        val copy = mutableMapOf<Node, Int>()
        val result = mutableListOf<Node>()
        var index = 0
        var pointer = node
        while (pointer != null) {
            copy[pointer] = index++
            result.add(Node(pointer.`val`))
            pointer = pointer.next
        }
        pointer = node
        index = 0
        while (pointer != null) {
            if (index < result.lastIndex) {
                result[index].next = result[index + 1]
            }
            result[index++].random = copy[pointer]?.let { result[it] }
            pointer = pointer.next
        }
        return result.firstOrNull()
    }
}
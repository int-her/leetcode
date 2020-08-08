package medium

import Node
import Solution

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */
class Solution116 : Solution() {
    override fun test() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun connect(root: Node?): Node? {
        return root?.let {
            var list = listOf(it)
            while (true) {
                val newList = list.flatMap { node -> listOf(node.left, node.right) }.filterNotNull()
                if (newList.isEmpty()) {
                    break
                } else {
                    (0 until newList.lastIndex).forEach { index -> newList[index].right = newList[index + 1] }
                }
                list = newList
            }
            it
        }
    }
}
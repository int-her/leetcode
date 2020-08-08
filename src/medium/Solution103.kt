package medium

import Solution
import TreeNode
import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution103 : Solution() {
    override fun test() {
        val input = arrayOf(
            TreeNode.makeTreeNode(listOf(1)),
            TreeNode.makeTreeNode(listOf(1, 2, 3)),
            TreeNode.makeTreeNode(listOf(3, 9, 20, null, null, 15, 7)),
            TreeNode.makeTreeNode(listOf(3, 9, 20, 2222, 1111, 15, 7))
        )
        input.forEach { println(zigzagLevelOrder(it)) }
    }

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        return root?.let {
            var queue = LinkedList<TreeNode>()
            var isReversed = false
            val result = mutableListOf<List<Int>>()
            queue.add(it)
            while (queue.isNotEmpty()) {
                val newQueue = LinkedList<TreeNode>()
                val subResult = mutableListOf<Int>()
                while (queue.isNotEmpty()) {
                    val node = queue.pop()
                    subResult.add(node.`val`)
                    node.left?.let { left -> newQueue.add(left) }
                    node.right?.let { right -> newQueue.add(right) }
                }
                queue = newQueue
                if (isReversed) {
                    subResult.reverse()
                }
                isReversed = !isReversed
                result.add(subResult)
            }
            result
        } ?: emptyList()
    }
}
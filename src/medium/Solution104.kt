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
class Solution104 : Solution() {
    override fun test() {
        val input = arrayOf(
            TreeNode.makeTreeNode(listOf()),
            TreeNode.makeTreeNode(listOf(1)),
            TreeNode.makeTreeNode(listOf(3, 9, 20, null, null, 15, 7))
        )
        input.forEach { println(maxDepth(it)) }
    }

    fun maxDepth(root: TreeNode?): Int {
        val queue = LinkedList<Pair<TreeNode?, Int>>()
        var max = 0
        queue.add(Pair(root, 1))
        while (queue.isNotEmpty()) {
            val (treeNode, level) = queue.pop()
            treeNode?.let {
                max = max.coerceAtLeast(level)
                queue.add(Pair(treeNode.left, level + 1))
                queue.add(Pair(treeNode.right, level + 1))
            }
        }
        return max
    }
}
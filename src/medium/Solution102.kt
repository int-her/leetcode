package medium

import main.Solution
import main.TreeNode
import java.util.*

/**
 * Example:
 * var ti = main.TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class main.TreeNode(var `val`: Int) {
 *     var left: main.TreeNode? = null
 *     var right: main.TreeNode? = null
 * }
 */
class Solution102 : Solution() {
    override fun test() {
        val input = arrayOf(
            TreeNode.makeTreeNode(listOf()),
            TreeNode.makeTreeNode(listOf(1)),
            TreeNode.makeTreeNode(listOf(3, 9, 20, null, null, 15, 7))
        )
        input.forEach { println(levelOrder(it)) }
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val queue = LinkedList<Pair<TreeNode?, Int>>()
        val result = mutableListOf<MutableList<Int>>()
        queue.add(Pair(root, 0))
        while (queue.isNotEmpty()) {
            val (treeNode, level) = queue.pop()
            treeNode?.let {
                if (level in result.indices) {
                    result[level].add(it.`val`)
                } else {
                    result.add(mutableListOf(it.`val`))
                }
                queue.add(Pair(treeNode.left, level + 1))
                queue.add(Pair(treeNode.right, level + 1))
            }
        }
        return result
    }
}
package medium

import main.Solution
import main.TreeNode

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
class Solution230 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(TreeNode.makeTreeNode(listOf(1)), 1),
            Pair(TreeNode.makeTreeNode(listOf(1, null, 2)), 1),
            Pair(TreeNode.makeTreeNode(listOf(2, 1, 3)), 1),
            Pair(TreeNode.makeTreeNode(listOf(3, 1, 4, null, 2)), 1),
            Pair(TreeNode.makeTreeNode(listOf(5, 3, 6, 2, 4, null, null, 1)), 3)
        )
        input.forEach { println(kthSmallest(it.first, it.second)) }
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        return intArrayOf(0, 0).also { helper(root, k, it) }.first()
    }

    fun helper(root: TreeNode?, k: Int, result: IntArray): Int {
        return root?.let { node ->
            val left = helper(node.left, k, result)
            if (result[1] == 1) {
                0
            } else if (k - left == 1) {
                result[0] = node.`val`
                result[1] = 1
                0
            } else {
                val right = helper(node.right, k - left - 1, result)
                if (right < 0) {
                    right
                } else {
                    left + right + 1
                }
            }
        } ?: 0
    }
}
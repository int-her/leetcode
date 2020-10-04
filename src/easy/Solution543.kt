package easy

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
class Solution543 : Solution() {
    private val dp = mutableMapOf<TreeNode, Int>()

    override fun test() {
        val input = arrayOf(
            TreeNode.makeTreeNode(listOf(1, 2, 3, 4, 5)),
            TreeNode.makeTreeNode(listOf(1)),
            TreeNode.makeTreeNode(listOf(1, 2))
        )
        input.forEach { println(diameterOfBinaryTree(it)) }
    }

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return root?.let {
            helper(root)
            helper2(root) - 1
        } ?: 0
    }

    fun helper(root: TreeNode?): Int {
        return root?.let {
            dp[it] ?: (helper(it.left).coerceAtLeast(helper(it.right)) + 1).also { length -> dp[it] = length }
        } ?: 0
    }

    fun helper2(root: TreeNode?): Int {
        return root?.let {
            (1 + (dp[it.left] ?: 0) + (dp[it.right] ?: 0)).coerceAtLeast(helper2(it.left)).coerceAtLeast(helper2(it.right))
        } ?: 0
    }
}
package easy

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
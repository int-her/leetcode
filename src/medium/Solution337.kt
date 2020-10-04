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
class Solution337 : Solution() {
    private val dp = mutableMapOf<TreeNode, Int>()

    override fun test() {
        val input = arrayOf(
            TreeNode.makeTreeNode(listOf(3, 2, 3, null, 3, null, 1)),
            TreeNode.makeTreeNode(listOf(3, 4, 5, 1, 3, null, 1))
        )
        input.forEach { println(rob(it)) }
    }

    fun rob(root: TreeNode?): Int {
        return dp[root] ?: root?.let {
            val a = it.`val` + rob(it.left?.left) + rob(it.left?.right) + rob(it.right?.left) + rob(it.right?.right)
            val b = rob(it.left) + rob(it.right)
            a.coerceAtLeast(b).also { result -> dp[root] = result }
        } ?: 0
    }
}
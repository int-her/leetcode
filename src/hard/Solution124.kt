package hard

import Solution
import TreeNode
import kotlin.properties.Delegates

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
class Solution124 : Solution() {
    lateinit var dp: MutableMap<TreeNode, Int>
    var max = Int.MIN_VALUE

    override fun test() {
        val input = arrayOf(
            TreeNode.makeTreeNode(listOf(1)),
            TreeNode.makeTreeNode(listOf(-3)),
            TreeNode.makeTreeNode(listOf(1, 2, 3)),
            TreeNode.makeTreeNode(listOf(-10, 9, 20, null, null, 15, 7)),
            TreeNode.makeTreeNode(listOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1))
        )
        input.forEach { println(maxPathSum(it)) }
    }

    fun maxPathSum(root: TreeNode?): Int {
        dp = mutableMapOf()
        max = Int.MIN_VALUE
        helper(root)
        return max
    }

    fun helper(root: TreeNode?): Int {
        return root?.let {
            val left = it.left?.let { leftChild -> dp[leftChild] ?: helper(leftChild) } ?: 0
            val right = it.right?.let { rightChild -> dp[rightChild] ?: helper(rightChild) } ?: 0
            max = max.coerceAtLeast(left + it.`val` + right)
            (left.coerceAtLeast(right) + it.`val`).coerceAtLeast(0).also { value -> dp[it] = value }
        } ?: 0
    }
}
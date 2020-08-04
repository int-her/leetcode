package medium

import Solution
import TreeNode

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
class Solution437 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(TreeNode.makeTreeNode(listOf()), 0),
            Pair(TreeNode.makeTreeNode(listOf(1)), 1),
            Pair(TreeNode.makeTreeNode(listOf(1)), 2),
            Pair(TreeNode.makeTreeNode(listOf(1, 1, 2)), 2),
            Pair(TreeNode.makeTreeNode(listOf(2, 1, 1)), 2),
            Pair(TreeNode.makeTreeNode(listOf(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1)), 8)
        )
        input.forEach { println(pathSum(it.first, it.second)) }
    }

    fun pathSum(root: TreeNode?, sum: Int): Int {
        return helper(root, sum).first
    }

    fun helper(root: TreeNode?, sum: Int): Pair<Int, List<Int>> {
        return root?.let { node ->
            val left = helper(node.left, sum)
            val right = helper(node.right, sum)
            val result = listOf(node.`val`) + (left.second + right.second).map { it + node.`val` }
            Pair(left.first + right.first + result.count { it == sum }, result)
        } ?: Pair(0, listOf())
    }
}
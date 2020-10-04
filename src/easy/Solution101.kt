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
class Solution101 : Solution() {
    override fun test() {
        val input = arrayOf(
            TreeNode.makeTreeNode(listOf(1, 2, 2)),
            TreeNode.makeTreeNode(listOf(1, 2, 2, 3, 4, 4, 3)),
            TreeNode.makeTreeNode(listOf(1, 2, 2, null, 3, null, 3))
        )
        input.forEach { println(isSymmetric(it)) }
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        return root?.let { helper(it.left, it.right) } ?: true
    }

    fun helper(left: TreeNode?, right: TreeNode?): Boolean {
        return left?.let {
            it.`val` == right?.`val` && helper(it.right, right.left) && helper(it.left, right.right)
        } ?: (right == null)
    }
}
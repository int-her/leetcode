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
class Solution94 : Solution() {
    override fun test() {
        val input = TreeNode(1)
        input.right = TreeNode(2)
        input.right!!.left = TreeNode(3)
        println(inorderTraversal(input))
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        return root?.let {
            inorderTraversal(it.left) + listOf(it.`val`) + inorderTraversal(it.right)
        } ?: emptyList()
    }
}
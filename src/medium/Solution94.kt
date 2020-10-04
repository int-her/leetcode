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
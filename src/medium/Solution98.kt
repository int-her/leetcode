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
class Solution98 : Solution() {
    override fun test() {
        val input1 = TreeNode(2)
        input1.left = TreeNode(1)
        input1.right = TreeNode(3)
        val input2 = TreeNode(5)
        input2.left = TreeNode(1)
        input2.right = TreeNode(4)
        input2.right!!.left = TreeNode(3)
        input2.right!!.right = TreeNode(6)
        println(isValidBST(input1))
        println(isValidBST(input2))
    }

    fun isValidBST(root: TreeNode?): Boolean {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun helper(root: TreeNode?, min: Long, max: Long): Boolean {
        return root?.let { it.`val` in (min + 1) until max && helper(it.left, min, it.`val`.toLong()) && helper(it.right, it.`val`.toLong(), max) } ?: true
    }
}
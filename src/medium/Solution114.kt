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
class Solution114 : Solution() {
    override fun test() {
        val input = arrayOf(
            TreeNode.makeTreeNode(listOf(1, 2, 5, 3, 4, null, 6))
        )
        input.forEach { flatten(it).run { println(it) }}
    }

    fun flatten(root: TreeNode?): Unit {
        var pointer = root
        while (pointer != null) {
            pointer.left?.let {
                var newPointer = it
                while (newPointer.right != null) {
                    newPointer = newPointer.right!!
                }
                newPointer.right = pointer!!.right
                pointer!!.right = pointer!!.left
                pointer!!.left = null
            }
            pointer = pointer.right
        }
    }
}
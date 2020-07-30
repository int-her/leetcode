package easy

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
class Solution617 : Solution() {
    override fun test() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        return if (t1 == null && t2 == null) {
            null
        } else {
            TreeNode((t1?.`val` ?: 0) + (t2?.`val` ?: 0))
                .also { it.left = mergeTrees(t1?.left, t2?.left) }
                .also { it.right = mergeTrees(t1?.right, t2?.right) }
        }
    }
}
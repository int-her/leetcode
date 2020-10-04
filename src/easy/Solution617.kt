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
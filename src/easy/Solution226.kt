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
class Solution226 : Solution() {
    override fun test() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun invertTree(root: TreeNode?): TreeNode? {
        return root?.let { treeNode ->
            TreeNode(treeNode.`val`)
                .also { it.left = invertTree(treeNode.right) }
                .also { it.right = invertTree(treeNode.left) }
        }
    }
}
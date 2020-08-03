package medium

import Solution
import TreeNode

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution236 : Solution() {
    override fun test() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var isVisited1 = mutableListOf(root)
        var isVisited2 = mutableListOf(root)
        helper(root, p!!, isVisited1)
        helper(root, q!!, isVisited2)
        if (isVisited1.size > isVisited2.size) {
            isVisited1 = isVisited2.also { isVisited2 = isVisited1 }
        }
        return isVisited1.indices.firstOrNull { isVisited1[it] != isVisited2[it] }?.let { isVisited1[it - 1] } ?: isVisited1.last()
    }

    fun helper(root: TreeNode?, p: TreeNode, isVisited: MutableList<TreeNode?>): Boolean {
        return when (root) {
            null -> false
            p -> true
            else -> {
                root.left?.let {
                    isVisited.add(it)
                    if (helper(it, p, isVisited)) {
                        return true
                    }
                    isVisited.removeAt(isVisited.lastIndex)
                }
                root.right?.let {
                    isVisited.add(it)
                    if (helper(it, p, isVisited)) {
                        return true
                    }
                    isVisited.removeAt(isVisited.lastIndex)
                }
                false
            }
        }
    }
}
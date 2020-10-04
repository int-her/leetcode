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
class Solution105 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(intArrayOf(), intArrayOf()),
            Pair(intArrayOf(1), intArrayOf(1)),
            Pair(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))
        )
        input.forEach { println(buildTree(it.first, it.second)) }
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return when (preorder.size) {
            0 -> null
            1 -> TreeNode(preorder.first())
            else -> TreeNode(preorder.first()).also {
                val numOfLeftChild = inorder.indexOf(preorder.first())
                it.left = buildTree(preorder.copyOfRange(1, numOfLeftChild + 1), inorder.copyOfRange(0, numOfLeftChild))
                it.right = buildTree(preorder.copyOfRange(numOfLeftChild + 1, preorder.size), inorder.copyOfRange(numOfLeftChild + 1, inorder.size))
            }
        }
    }
}
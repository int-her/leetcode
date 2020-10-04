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
class Solution108 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(-10, -3, 0, 5, 9)
        )
        input.forEach { println(sortedArrayToBST(it)) }
    }

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return helper(0, nums.size, nums)
    }

    fun helper(start: Int, end: Int, nums: IntArray): TreeNode? {
        return when (end - start) {
            0 -> null
            1 -> TreeNode(nums[start])
            else -> {
                val mid = (start + end) / 2
                TreeNode(nums[mid]).also {
                    it.left = helper(start, mid, nums)
                    it.right = helper(mid + 1, end, nums)
                }
            }
        }
    }
}
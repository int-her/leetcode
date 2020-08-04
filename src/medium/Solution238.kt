package medium

import Solution

class Solution238 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(3, 2, 1, 4),
            intArrayOf(5, 4, 3, 2, 1)
        )
        input.forEach { println(productExceptSelf(it).joinToString()) }
    }

    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }
        var multiplier = 1
        (1 until nums.size).forEach { index ->
            multiplier *= nums[index - 1]
            result[index] *= multiplier
        }
        multiplier = 1
        (0 until nums.lastIndex).reversed().forEach { index ->
            multiplier *= nums[index + 1]
            result[index] *= multiplier
        }
        return result
    }
}
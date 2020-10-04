package medium

import main.Solution

class Solution300 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(),
            intArrayOf(1),
            intArrayOf(2, 1),
            intArrayOf(3, 1, 2, 4),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 2, 3, 4, 5, 1, 3, 5, 7, 9),
            intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
        )
        input.forEach { println(lengthOfLIS(it)) }
    }

    fun lengthOfLIS(nums: IntArray): Int {
        return if (nums.isEmpty()) {
            0
        } else {
            val dp = IntArray(nums.size) { 1 }
            nums.indices.forEach { i ->
                (0 until i).forEach { j ->
                    if (nums[i] > nums[j]) {
                        dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
                    }
                }
            }
            dp.max()!!
        }
    }
}
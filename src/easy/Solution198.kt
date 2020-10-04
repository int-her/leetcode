package easy

import main.Solution

class Solution198 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(),
            intArrayOf(2),
            intArrayOf(1, 3),
            intArrayOf(3, 1),
            intArrayOf(1, 3, 1),
            intArrayOf(1, 2, 3, 1),
            intArrayOf(2, 7, 9, 3, 1)
        )
        input.forEach { println(rob(it)) }
    }

    fun rob(nums: IntArray): Int {
        return when (nums.size < 2) {
            true -> (nums.firstOrNull() ?: 0).coerceAtLeast(nums.lastOrNull() ?: 0)
            false -> {
                val dp = IntArray(nums.size)
                dp[0] = nums.first()
                dp[1] = nums.first().coerceAtLeast(nums[1])
                (2 until nums.size).forEach {
                    dp[it] = dp[it - 1].coerceAtLeast(dp[it - 2] + nums[it])
                }
                dp.last()
            }
        }
    }
}
package medium

import Solution

class Solution494 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(intArrayOf(1, 1, 1, 1, 1), 3),
            Pair(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1), 1)
        )
        input.forEach { println(findTargetSumWays(it.first, it.second)) }
    }

    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        var dp = mutableMapOf<Int, Int>()
        dp[0] = 1
        nums.forEach { num ->
            val temp = mutableMapOf<Int, Int>()
            dp.keys.forEach { key ->
                temp[key + num] = (temp[key + num] ?: 0) + (dp[key] ?: 0)
                temp[key - num] = (temp[key - num] ?: 0) + (dp[key] ?: 0)
            }
            dp = temp
        }
        return dp[S] ?: 0
    }
}
package medium

import main.Solution

class Solution309 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(1),
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(2, 1, 4),
            intArrayOf(1, 2, 3, 0, 2)
        )
        input.forEach { println(maxProfit(it)) }
    }

    fun maxProfit(prices: IntArray): Int {
        val dp = mutableMapOf<Int, Int>()
        return helper(0, prices, dp)
    }

    fun helper(index: Int, prices: IntArray, dp: MutableMap<Int, Int>): Int {
        return if (index >= prices.lastIndex) {
            0
        } else {
            ((index + 1..prices.lastIndex).map {
                -prices[index] + prices[it] + (dp[it + 2] ?: helper(it + 2, prices, dp))
            } + listOf(dp[index + 1] ?: helper(index + 1, prices, dp))).max()!!.also { dp[index] = it }
        }
    }
}
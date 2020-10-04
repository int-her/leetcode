package easy

import main.Solution

class Solution122 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(),
            intArrayOf(1),
            intArrayOf(7, 1, 5, 3, 6, 4),
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(7, 6, 4, 3, 1)
        )
        input.forEach { println(maxProfit(it)) }
    }

    fun maxProfit(prices: IntArray): Int {
        var result = 0
        (1 until prices.size).forEach {
            result += (prices[it] - prices[it - 1]).takeIf { diff -> diff >= 0 } ?: 0
        }
        return result
    }

    fun maxProfit2(prices: IntArray): Int {
        return helper(0, prices, mutableMapOf())
    }

    fun helper(start: Int, prices: IntArray, dp: MutableMap<Int, Int>): Int {
        return when (start >= prices.lastIndex) {
            true -> 0
            false -> {
                ((start + 1 until prices.size).filter { end -> prices[end] > prices[start] }.map { end ->
                    prices[end] - prices[start] + (dp[end + 1] ?: helper(end + 1, prices, dp))
                }.max() ?: 0).coerceAtLeast(dp[start + 1] ?: helper(start + 1, prices, dp))
            }
        }.also { dp[start] = it }
    }
}
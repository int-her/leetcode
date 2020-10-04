package easy

import main.Solution

class Solution121 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(),
            intArrayOf(0),
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(7, 1, 5, 3, 6, 4),
            intArrayOf(7, 6, 4, 3, 1)
        )
        input.forEach { println(maxProfit(it)) }
    }

    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var profit = 0
        prices.forEach {
            min = min.coerceAtMost(it)
            profit = profit.coerceAtLeast((it - min).coerceAtLeast(0))
        }
        return profit
    }
}
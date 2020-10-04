package medium

import main.Solution

class Solution322 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(intArrayOf(1, 2, 5), 11),
            Pair(intArrayOf(2), 3),
            Pair(intArrayOf(186, 419, 83, 408), 6249),
            Pair(intArrayOf(270, 373, 487, 5, 62), 8121),
            Pair(intArrayOf(227, 99, 328, 299, 42, 322), 9847),
            Pair(intArrayOf(205, 37, 253, 463, 441, 129, 156, 429, 101, 423, 311), 6653)
        )
        input.forEach { println(coinChange(it.first, it.second)) }
    }

    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = mutableMapOf<Int, Int>()
        coins.sort()
        return helper(coins, amount, dp)
    }

    fun helper(coins: IntArray, amount: Int, dp: MutableMap<Int, Int>): Int {
        return when (amount) {
            0 -> 0
            else -> {
                var min = Int.MAX_VALUE
                coins.forEach { coin ->
                    if (amount >= coin) {
                        val dpValue = dp[amount - coin] ?: helper(coins, amount - coin, dp)
                        if (dpValue != -1) {
                            min = min.coerceAtMost(dpValue + 1)
                        }
                    }
                }
                (if (min == Int.MAX_VALUE) -1 else min).also { dp[amount] = it }
            }
        }
    }
}
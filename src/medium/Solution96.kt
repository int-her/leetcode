package medium

import main.Solution

class Solution96 : Solution() {
    override fun test() {
        (1..5).forEach { println(numTrees(it)) }
    }

    fun numTrees(n: Int): Int {
        val dp = Array(20) { 1 }
        (1..n).forEach { i ->
            dp[i] = (0 until i).sumBy {
                dp[it] * dp[i - it - 1]
            }
        }
        return dp[n]
    }
}
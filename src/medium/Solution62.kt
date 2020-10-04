package medium

import main.Solution

class Solution62 : Solution() {
    override fun test() {
        println(uniquePaths(1, 1))
        println(uniquePaths(3, 2))
        println(uniquePaths(7, 3))
    }

    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m + 1) { IntArray(n + 1) { 0 } }
        dp[1][0] = 1
        (1..m).forEach { i ->
            (1..n).forEach { j ->
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m][n]
    }
}
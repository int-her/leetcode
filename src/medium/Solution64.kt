package medium

import Solution

class Solution64 : Solution() {
    override fun test() {
        println(minPathSum(arrayOf(intArrayOf(1))))
        println(minPathSum(arrayOf(intArrayOf(1, 1, 1, 1, 1, 1, 1))))
        println(minPathSum(arrayOf(intArrayOf(1, 1, 1, 1, 1, 1, 1), intArrayOf(0, 0, 0, 0, 0, 0, 1), intArrayOf(1, 1, 1, 1, 1, 1, 1), intArrayOf(1, 0, 0, 0, 0, 0, 0), intArrayOf(1, 1, 1, 1, 1, 1, 1))))
        println(minPathSum(arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))))
    }

    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid.first().size
        val dp = Array(m + 1) { IntArray(n + 1) { 0 } }
        dp[0] = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0][1] = 0
        (1..m).forEach { i ->
            dp[i][0] = Int.MAX_VALUE
            (1..n).forEach { j ->
                dp[i][j] = (if (dp[i - 1][j] < dp[i][j - 1]) dp[i - 1][j] else dp[i][j - 1]) + grid[i - 1][j - 1]
            }
        }
        return dp[m][n]
    }
}
package hard

import Solution

class Solution72 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair("", ""),
            Pair("abcde", ""),
            Pair("horse", "ros"),
            Pair("intention", "execution")
        )
        input.forEach { println(minDistance(it.first, it.second)) }
    }

    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
        dp.indices.forEach { dp[it][0] = it }
        dp.first().indices.forEach { dp[0][it] = it }
        (1..word1.length).forEach { i ->
            (1..word2.length).forEach { j ->
                dp[i][j] = if (word1[i - 1] == word2[j - 1]) dp[i - 1][j - 1] else dp[i - 1][j - 1].coerceAtMost(dp[i - 1][j]).coerceAtMost(dp[i][j - 1]) + 1
            }
        }
        return dp[word1.length][word2.length]
    }
}
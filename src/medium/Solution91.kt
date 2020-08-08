package medium

import Solution

class Solution91 : Solution() {
    val dp = mutableMapOf<String, Int>()

    override fun test() {
        val input = arrayOf(
            "12", "38", "226"
        )
        input.forEach { println(numDecodings(it)) }
    }

    // The problem description is too poor.
    fun numDecodings(s: String): Int {
        return when {
            s.startsWith('0') -> 0
            s.length in 0..1 -> 1
            else -> {
                dp[s.substring(1)] ?: numDecodings(s.substring(1)) +
                        if (s.substring(0, 2).toInt() <= 26) dp[s.substring(2)] ?: numDecodings(s.substring(2)) else 0
            }
        }.also { dp[s] = it }
    }
}
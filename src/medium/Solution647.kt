package medium

import main.Solution

class Solution647 : Solution() {
    override fun test() {
        val input = arrayOf(
            "",
            "a",
            "abc",
            "aaa"
        )
        input.forEach { println(countSubstrings(it)) }
    }

    fun countSubstrings(s: String): Int {
        val dp = mutableMapOf<Int, MutableList<Int>>()
        s.indices.forEach { dp[it] = mutableListOf(1) }
        (1 until s.length).forEach {
            if (s[it] == s[it - 1]) {
                dp[it]!!.add(2)
            }
        }
        (1 until s.length).forEach { i ->
            val candidate = dp[i - 1]!!
            candidate.forEach { j ->
                if (i - j - 1 >= 0 && s[i] == s[i - j - 1]) {
                    dp[i]!!.add(j + 2)
                }
            }
        }
        return dp.values.fold(0) { sum, list -> sum + list.count() }
    }
}
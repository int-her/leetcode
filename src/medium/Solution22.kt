package medium

import main.Solution

class Solution22 : Solution() {
    val dp: MutableMap<Int, List<String>> = mutableMapOf(Pair(0, listOf("")), Pair(1, listOf("()")))

    override fun test() {
        println(generateParenthesis(2))
        println(generateParenthesis(3))
        println(generateParenthesis(4))
    }

    fun generateParenthesis(n: Int): List<String> {
        return if (n < 2) {
            dp[n]!!
        } else {
            (1 until n).flatMap { length ->
                val front = dp[length] ?: let { dp[length] = generateParenthesis(length) }.let { dp[length]!! }
                val back = dp[n - length] ?: let { dp[n - length] = generateParenthesis(n - length) }.let { dp[n - length]!! }
                front.flatMap { f -> back.map { b -> "$f$b" }}
            }.plus(generateParenthesis(n - 1).map { "($it)" }).distinct()
        }
    }
}
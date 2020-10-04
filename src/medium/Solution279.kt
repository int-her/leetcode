package medium

import main.Solution
import kotlin.math.sqrt

class Solution279 : Solution() {
    private val dp = mutableMapOf<Int, Int>()

    override fun test() {
        val input = arrayOf(1, 2, 3, 4, 5, 12, 13)
        input.forEach { println(numSquares(it)) }
    }

    fun numSquares(n: Int): Int {
        return dp[n] ?: let {
            val root = sqrt(n.toDouble())
            if (root.toInt() * root.toInt() == n) {
                1
            } else {
                var min = Int.MAX_VALUE
                (1..root.toInt()).forEach {
                    min = min.coerceAtMost((dp[n - it * it] ?: numSquares(n - it * it)) + 1)
                }
                min
            }
        }.also { dp[n] = it }
    }
}
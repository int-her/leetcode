package medium

import main.Solution

class Solution152 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(-1),
            intArrayOf(1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1, -1, -2),
            intArrayOf(-2, -1, -1, -1, -1, -2),
            intArrayOf(-1, -1, 0, -1, -3, -1),
            intArrayOf(2, 3, -2, 4),
            intArrayOf(-2, 0, -1)
        )
        input.forEach { println(maxProduct(it)) }
    }

    fun maxProduct(nums: IntArray): Int {
        val dp = mutableMapOf<Int, Pair<Int, Int>>()
        nums.forEachIndexed { index, num ->
            val (min, max) = dp[index - 1] ?: Pair(0, 1)
            dp[index] = when (num > 0) {
                true -> Pair(if (min < 0) min * num else 0, if (max > 0) max * num else num)
                false -> Pair(if (max > 0) max * num else num, if (min < 0) min * num else 0)
            }
        }
        val result = dp.map { it.value.second }.max()!!
        return if (result > 0 || (result == 0 && nums.any { it == 0 })) {
            result
        } else {
            dp.map { it.value.first }.max()!!
        }
    }
}
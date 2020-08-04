package medium

import Solution

class Solution416 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 3, 4, 7),
            intArrayOf(1, 2, 3, 4, 5, 6),
            intArrayOf(3, 5, 5, 5, 6, 6),
            intArrayOf(1, 5, 11, 5),
            intArrayOf(1, 2, 3, 5)
        )
        input.forEach { println(canPartition(it)) }
    }

    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        return when (sum % 2) {
            0 -> {
                var set = setOf(0)
                nums.also { it.sort() }.forEach { num ->
                    set = set.flatMap { listOf(it, it + num) }.toSet()
                }
                set.contains(sum / 2)
            }
            else -> false
        }
    }
}
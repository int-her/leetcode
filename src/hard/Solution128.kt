package hard

import Solution

class Solution128 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(),
            intArrayOf(1),
            intArrayOf(0, 1),
            intArrayOf(100, 4, 200, 1, 3, 2)
        )
        input.forEach { println(longestConsecutive(it)) }
    }

    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        var max = 0
        nums.forEach { num ->
            if (num - 1 !in set) {
                var count = 0
                while (num + count in set) {
                    count++
                }
                max = max.coerceAtLeast(count)
            }
        }
        return max
    }
}
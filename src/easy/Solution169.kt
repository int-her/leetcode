package easy

import Solution

class Solution169 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(3, 2, 3),
            intArrayOf(2, 2, 1, 1, 1, 2, 2)
        )
        input.forEach { println(majorityElement(it)) }
    }

    fun majorityElement(nums: IntArray): Int {
        val count = mutableMapOf<Int, Int>()
        nums.forEach { count[it] = (count[it] ?: 0) + 1 }
        return count.maxBy { it.value }!!.key
    }
}
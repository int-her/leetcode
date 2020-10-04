package medium

import main.Solution

class Solution347 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(intArrayOf(1, 1, 1, 2, 2, 3), 2),
            Pair(intArrayOf(1), 1)
        )
        input.forEach { println(topKFrequent(it.first, it.second).joinToString()) }
    }

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val count = mutableMapOf<Int, Int>()
        nums.forEach {
            count[it] = (count[it] ?: 0) + 1
        }
        return count.toList().sortedByDescending { it.second }.map { it.first }.subList(0, k).toIntArray()
    }
}
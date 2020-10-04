package medium

import main.Solution

class Solution560 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(intArrayOf(), 0),
            Pair(intArrayOf(), 1),
            Pair(intArrayOf(1), 2),
            Pair(intArrayOf(1, 2, 3, 2, 1), 5),
            Pair(intArrayOf(1, 1, 1), 2)
        )
        input.forEach { println(subarraySum2(it.first, it.second)) }
    }

    // O(n^2)
    fun subarraySum(nums: IntArray, k: Int): Int {
        return if (nums.isEmpty()) {
            0
        } else {
            var result = 0
            val sum = mutableListOf<Int>()
            nums.forEach { num ->
                sum.add(0)
                sum.indices.forEach {
                    sum[it] += num
                    if (sum[it] == k) {
                        result++
                    }
                }
            }
            result
        }
    }

    // O(n)
    fun subarraySum2(nums: IntArray, k: Int): Int {
        val sumCount = mutableMapOf<Int, Int>()
        sumCount[0] = 1
        var sum = 0
        var result = 0
        nums.forEach { num ->
            sum += num
            result += sumCount[sum - k] ?: 0
            sumCount[sum] = (sumCount[sum] ?: 0) + 1
        }
        return result
    }
}
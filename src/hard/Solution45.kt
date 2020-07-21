package hard

import Solution

class Solution45 : Solution() {
    override fun test() {
        println(jump(intArrayOf(1)))
        println(jump(intArrayOf(2, 1)))
        println(jump(intArrayOf(2, 3, 1, 1, 4)))
        println(jump(intArrayOf(2, 3, 0, 1, 4)))
        println(jump(IntArray(25000) { 25000 - it }))
    }

    // DP로 풀면 timeout
    // Use greedy
    fun jump(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }
        var count = 0
        var maxIndex = 0
        while (true) {
            count++
            if (maxIndex + nums[maxIndex] >= nums.size - 1) {
                return count
            } else {
                maxIndex = (1..nums[maxIndex]).map { Pair(maxIndex + it, maxIndex + it + nums[maxIndex + it]) }.maxBy { it.second }!!.first
            }
        }
    }
}
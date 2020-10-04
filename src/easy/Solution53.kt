package easy

import main.Solution

class Solution53 : Solution() {
    override fun test() {
        println(maxSubArray(intArrayOf(0)))
        println(maxSubArray(intArrayOf(-1, -2, -3)))
        println(maxSubArray(intArrayOf(-3, -2, -1)))
        println(maxSubArray(intArrayOf(3, 2, 1, -1, 1, -1, 1, 1, -2)))
        println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

    fun maxSubArray(nums: IntArray): Int {
        var max = nums.first()
        return if (nums.size == 1) {
            max
        } else {
            var temp = if (max > 0) max else 0
            (1 until nums.size).forEach { index ->
                temp += nums[index]
                if (temp > max) {
                    max = temp
                }
                if (temp < 0) {
                    temp = 0
                }
            }
            max
        }
    }
}
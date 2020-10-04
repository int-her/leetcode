package medium

import main.Solution

class Solution162 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(1, 2, 3, 1),
            intArrayOf(1, 2, 1, 3, 5, 6, 4),
            intArrayOf(1, 6, 5, 4, 3, 2, 1)
        )
        input.forEach { println(findPeakElement(it)) }
    }

    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val mid = (left + right) / 2
            if (nums[mid] > nums[mid + 1]) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
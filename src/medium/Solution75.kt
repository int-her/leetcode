package medium

import main.Solution

class Solution75 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(0),
            intArrayOf(1),
            intArrayOf(2, 0, 1),
            intArrayOf(2, 0, 2, 1, 1, 0),
            intArrayOf(2, 2, 2, 1, 1, 0),
            intArrayOf(0, 0, 2, 1, 1, 0),
            intArrayOf(1, 1, 2, 1, 1, 0)
        )
        input.forEach {
            sortColors(it)
            println(it.joinToString())
        }
    }

    // one-pass algorithm
    fun sortColors(nums: IntArray): Unit {
        var left = 0
        var mid = 0
        var right = nums.lastIndex
        while (mid <= right) {
            when (nums[mid]) {
                0 -> {
                    nums[mid++] = nums[left]
                    nums[left++] = 0
                }
                1 -> mid++
                2 -> {
                    nums[mid] = nums[right]
                    nums[right--] = 2
                }
            }
        }
    }
}
package medium

import Solution

class Solution34 : Solution() {
    override fun test() {
        println(searchRange(intArrayOf(1), 1).joinToString())
        println(searchRange(intArrayOf(1), 2).joinToString())
        println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).joinToString())
        println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).joinToString())
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        var result = intArrayOf()
        var left = 0
        var right = nums.size - 1
        var mid = (left + right) / 2
        while (right - left > 10) {
            if (nums[mid] >= target) {
                right = mid
                mid = (left + right) / 2
            } else {
                left = mid
                mid = (left + right) / 2
            }
        }
        result = result.plus(nums.copyOfRange(left, right + 1).indexOfLast { it < target } + left + 1)
        left = 0
        right = nums.size - 1
        mid = (left + right) / 2
        while (right - left > 10) {
            if (nums[mid] <= target) {
                left = mid
                mid = (left + right) / 2
            } else {
                right = mid
                mid = (left + right) / 2
            }
        }
        val temp = nums.copyOfRange(left, right + 1).indexOfFirst { it > target }
        result = result.plus((if (temp == -1) right - left + 1 else temp) + left - 1)
        return if (result[0] > result[1]) intArrayOf(-1, -1) else result
    }
}
package medium

import Solution

class Solution33 : Solution() {
    override fun test() {
        println(search(intArrayOf(1), 1))
        println(search(intArrayOf(15, 40, 44, 85, 172, 0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14), 3))
        println(search(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 144, 344, 564, 1231, 1232), 0))
    }

    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var isSort = false
        while (right - left > 10) {
            val mid = (left + right) / 2
            if (!isSort) {
                if (nums[left] < nums[mid]) {
                    if (nums[left] <= target && nums[mid] > target) {
                        right = mid
                        isSort = true
                    } else {
                        left = mid
                    }
                } else {
                    if (nums[mid] <= target && nums[right] >= target) {
                        left = mid
                        isSort = true
                    } else {
                        right = mid
                    }
                }
            } else {
                if (nums[mid] < target) {
                    left = mid
                } else {
                    right = mid
                }
            }
        }
        val index = if (right - left >= 0) {
            nums.copyOfRange(left, right + 1).indexOf(target)
        } else {
            -1
        }
        return if (index == -1) index else index + left
    }
}
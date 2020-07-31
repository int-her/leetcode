package medium

import Solution

class Solution287 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(1, 3, 4, 2, 2),
            intArrayOf(3, 1, 3, 4, 2),
            intArrayOf(1, 1),
            intArrayOf(2, 1, 2),
            intArrayOf(3, 1, 1, 2),
            intArrayOf(3, 2, 1, 2),
            intArrayOf(1, 4, 2, 3, 4),
            intArrayOf(2, 1, 3, 2, 4)
        )
        input.forEach { println(findDuplicate(it)) }
    }

    /**
     * Note:
     * You must not modify the array (assume the array is read only).
     * You must use only constant, O(1) extra space.
     * Your runtime complexity should be less than O(n^2).
     * There is only one duplicate number in the array, but it could be repeated more than once.
     *
     * My solution:
     * O(nlogn)
     */
    fun findDuplicate(nums: IntArray): Int {
        var left = 1
        var right = nums.lastIndex
        var mid = (left + right) / 2
        while (left < right) {
            var count = 0
            nums.forEach { if (it in left..mid) count++ }
            if (mid - left + 1 >= count) {
                left = mid + 1
                mid = (left + right) / 2
            } else {
                right = mid
                mid = (left + right) / 2
            }
        }
        return left
    }
}
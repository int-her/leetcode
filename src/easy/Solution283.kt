package easy

import Solution

class Solution283 : Solution() {
    override fun test() {
        val input = intArrayOf(0, 1, 0, 3, 12)
        moveZeroes(input)
        println(input.joinToString())
    }

    fun moveZeroes(nums: IntArray): Unit {
        var zeroIndex = 0
        nums.indices.forEach { index ->
            nums[zeroIndex] = nums[index].also { nums[index] = nums[zeroIndex] }
            if (nums[zeroIndex] != 0) {
                zeroIndex++
            }
        }
    }
}
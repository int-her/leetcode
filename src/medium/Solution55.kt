package medium

import main.Solution

class Solution55 : Solution() {
    override fun test() {
        println(canJump(intArrayOf(2, 3, 1, 1, 4)))
        println(canJump(intArrayOf(3, 2, 1, 0, 4)))
    }

    fun canJump(nums: IntArray): Boolean {
        var index = 0
        while (true) {
            if (index + nums[index] >= nums.size - 1) {
                return true
            }
            val next = (index..index + nums[index]).maxBy { it + nums[it] }!!
            if (index == next) {
                break
            } else {
                index = next
            }
        }
        return false
    }
}
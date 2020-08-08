package easy

import Solution

class Solution26 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(1, 1, 2),
            intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        )
        input.forEach {
            println("${removeDuplicates(it)} | ${it.joinToString()}")
        }
    }

    fun removeDuplicates(nums: IntArray): Int {
        return if (nums.isEmpty()) {
            0
        } else {
            var pivot = nums.first()
            var index = 1
            (1 until nums.size).forEach {
                if (nums[it] != pivot) {
                    nums[index++] = nums[it]
                    pivot = nums[it]
                }
            }
            index
        }
    }
}
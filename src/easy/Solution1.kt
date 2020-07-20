package easy

import Solution
import java.lang.Exception

class Solution1 : Solution() {
    override fun test() {
        val nums: IntArray = intArrayOf(2, 7, 11, 15)
        val target = 9
        print(twoSum(nums, target).joinToString())
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { i, number ->
            (i + 1 until nums.size).forEach { j ->
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        throw Exception()
    }
}
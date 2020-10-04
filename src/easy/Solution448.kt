package easy

import main.Solution
import kotlin.math.abs

class Solution448 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
        )
        input.forEach { println(findDisappearedNumbers(it)) }
    }

    // Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        nums.indices.forEach { index ->
            nums[abs(nums[index]) - 1] = -abs(nums[abs(nums[index]) - 1])
        }
        nums.indices.forEach { index ->
            if (nums[index] > 0) {
                result.add(index + 1)
            }
        }
        return result
    }
}
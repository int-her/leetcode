package medium

import Solution

class Solution78 : Solution() {
    lateinit var dp: MutableList<List<List<Int>>?>
    override fun test() {
        println(subsets(intArrayOf(1, 2, 3)))
    }

    fun subsets(nums: IntArray): List<List<Int>> {
        dp = MutableList(nums.size) { null }
        return helper(nums)
    }

    fun helper(nums: IntArray): List<List<Int>> {
        return if (nums.isEmpty()) {
            listOf(listOf())
        } else {
            val subsets = dp[nums.size - 1] ?: let {
                dp[nums.size - 1] = helper(nums.copyOf(nums.size - 1))
                dp[nums.size - 1]!!
            }
            subsets + subsets.map { it + listOf(nums.last()) }
        }
    }
}
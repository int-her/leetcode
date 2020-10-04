package medium

import main.Solution

class Solution46 : Solution() {
    override fun test() {
        println(permute(intArrayOf()))
        println(permute(intArrayOf(1)))
        println(permute(intArrayOf(1, 2)))
        println(permute(intArrayOf(1, 2, 5)))
        println(permute(intArrayOf(1, 2, 3, 5)))
    }

    fun permute(nums: IntArray): List<List<Int>> {
        return if (nums.size == 1) {
            listOf(listOf(nums.first()))
        } else {
            nums.foldIndexed(listOf()) { index, result, num ->
                result + permute(nums.copyOfRange(0, index) + nums.copyOfRange(index + 1, nums.size)).map { listOf(num) + it }
            }
        }
    }
}
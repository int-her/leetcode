package easy

import main.Solution

class Solution136 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(2, 2, 1),
            intArrayOf(4, 1, 2, 1, 2)
        )
        input.forEach { println(singleNumber(it)) }
    }

    // You should use XOR operation to have a linear runtime complexity without using extra memory.
    fun singleNumber(nums: IntArray): Int {
        return nums.foldRight(0) { num, result -> result.xor(num) }
    }
}
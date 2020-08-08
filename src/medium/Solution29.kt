package medium

import Solution
import kotlin.math.sign

class Solution29 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(10, 3),
            Pair(7, -3),
            Pair(0, -1),
            Pair(0, 1),
            Pair(-2147483648, -1),
            Pair(-2147483648, 1)
        )
        input.forEach { println(divide(it.first, it.second)) }
    }

    // Divide two integers without ithout using multiplication, division and mod operator.
    fun divide(dividend: Int, divisor: Int): Int {
        val nums = mutableListOf(Pair(if (divisor > 0) divisor.toLong() else 0L - divisor.toLong(), 1L))
        val abs = if (dividend >= 0) dividend.toLong() else 0L - dividend.toLong()
        while (nums.last().first < abs) {
            nums.add(Pair(nums.last().first + nums.last().first, nums.last().second + nums.last().second))
        }
        var quotient = 0L
        var rest = abs
        var index = nums.lastIndex
        while (index >= 0) {
            if (nums[index].first <= rest) {
                rest -= nums[index].first
                quotient += nums[index].second
            }
            index--
        }
        quotient = if (dividend.sign == divisor.sign) quotient else 0L - quotient
        return when (quotient) {
            in Int.MIN_VALUE..Int.MAX_VALUE -> quotient.toInt()
            else -> Int.MAX_VALUE
        }
    }
}